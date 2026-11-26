package de.marmaro.krt.ffupdater.app.impl

import android.content.Context
import android.os.Build
import androidx.annotation.Keep
import androidx.annotation.MainThread
import de.marmaro.krt.ffupdater.R
import de.marmaro.krt.ffupdater.app.App
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.BASED_ON_FIREFOX
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.GOOD_PRIVACY_BROWSER
import de.marmaro.krt.ffupdater.app.entity.LatestVersion
import de.marmaro.krt.ffupdater.app.entity.Version
import de.marmaro.krt.ffupdater.app.impl.base.AbiAssetMatcher
import de.marmaro.krt.ffupdater.device.ABI
import de.marmaro.krt.ffupdater.device.DeviceAbiExtractor
import de.marmaro.krt.ffupdater.network.exceptions.NetworkException
import de.marmaro.krt.ffupdater.network.github.GithubConsumer
import de.marmaro.krt.ffupdater.settings.DeviceSettingsHelper

/**
 * https://github.com/BrowserWorks/waterfox-android
 * https://api.github.com/repos/BrowserWorks/waterfox-android/releases/latest
 *
 * Tags look like "1.2.11-2026445488" (version + build id). The GitHub APK is signed with a different
 * key than the Google Play build, so an existing Play Store installation can't be updated by FFUpdater.
 */
@Keep
object Waterfox : AppBase() {
    override val app = App.WATERFOX
    override val packageName = "net.waterfox.android.release"
    override val title = R.string.waterfox__title
    override val description = R.string.waterfox__description
    override val installationWarning = R.string.waterfox__warning
    override val downloadSource = "GitHub"
    override val icon = R.drawable.ic_logo_waterfox
    override val minApiLevel = Build.VERSION_CODES.O // 8.0, see the Play Store listing
    override val supportedAbis = listOf(ABI.ARM64_V8A, ABI.X86_64)
    // TODO: replace with the SHA-256 of the signing certificate of the GitHub release APK
    //  (apksigner verify --print-certs waterfox-*.apk)
    override val signatureHash = "f091ca3998b49e159d23ee95586999c75d0b7023fcf9c54192a81300ac166e17"
    override val projectPage = "https://github.com/BrowserWorks/waterfox-android"
    override val displayCategory = listOf(BASED_ON_FIREFOX, GOOD_PRIVACY_BROWSER)
    override val hostnameForInternetCheck = "https://api.github.com"

    @MainThread
    @Throws(NetworkException::class)
    override suspend fun fetchLatestUpdate(context: Context): LatestVersion {
        val abi = DeviceAbiExtractor.findBestAbi(supportedAbis, DeviceSettingsHelper.prefer32BitApks)
        val result = GithubConsumer.findLatestRelease(
            repository = GithubConsumer.GithubRepo("BrowserWorks", "waterfox-android", 0),
            isValidRelease = { !it.isPreRelease },
            isSuitableAsset = { AbiAssetMatcher.isApkFor(it.name, abi) },
            requireReleaseDescription = false,
        )
        // "1.2.11-2026445488" -> "1.2.11"
        val version = result.tagName.removePrefix("v").substringBefore("-")
        return LatestVersion(
            downloadUrl = result.url,
            version = Version(version),
            publishDate = result.releaseDate,
            exactFileSizeBytesOfDownload = result.fileSizeBytes,
            fileHash = null,
        )
    }
}
