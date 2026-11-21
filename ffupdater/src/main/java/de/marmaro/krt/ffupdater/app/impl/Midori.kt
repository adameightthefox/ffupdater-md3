package de.marmaro.krt.ffupdater.app.impl

import android.content.Context
import android.os.Build
import androidx.annotation.Keep
import androidx.annotation.MainThread
import de.marmaro.krt.ffupdater.R
import de.marmaro.krt.ffupdater.app.App
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.BASED_ON_FIREFOX
import de.marmaro.krt.ffupdater.app.entity.LatestVersion
import de.marmaro.krt.ffupdater.app.entity.Version
import de.marmaro.krt.ffupdater.app.impl.base.AbiAssetMatcher
import de.marmaro.krt.ffupdater.device.ABI
import de.marmaro.krt.ffupdater.device.DeviceAbiExtractor
import de.marmaro.krt.ffupdater.network.exceptions.NetworkException
import de.marmaro.krt.ffupdater.network.github.GithubConsumer
import de.marmaro.krt.ffupdater.settings.DeviceSettingsHelper

/**
 * https://github.com/goastian/midori-android (GeckoView based, MPL-2.0)
 * Also available on F-Droid / Google Play as org.midorinext.android.
 */
@Keep
object Midori : AppBase() {
    override val app = App.MIDORI
    override val packageName = "org.midorinext.android"
    override val title = R.string.midori__title
    override val description = R.string.midori__description
    override val installationWarning = R.string.midori__warning
    override val downloadSource = "GitHub"
    override val icon = R.drawable.ic_logo_midori
    override val minApiLevel = Build.VERSION_CODES.N // TODO: verify against the APK (minSdkVersion)
    override val supportedAbis = listOf(ABI.ARM64_V8A, ABI.ARMEABI_V7A, ABI.X86_64, ABI.X86)
    // TODO: replace with the SHA-256 of the signing certificate of the GitHub release APK
    override val signatureHash = "0000000000000000000000000000000000000000000000000000000000000000"
    override val projectPage = "https://github.com/goastian/midori-android"
    override val displayCategory = listOf(BASED_ON_FIREFOX)
    override val hostnameForInternetCheck = "https://api.github.com"

    @MainThread
    @Throws(NetworkException::class)
    override suspend fun fetchLatestUpdate(context: Context): LatestVersion {
        val abi = DeviceAbiExtractor.findBestAbi(supportedAbis, DeviceSettingsHelper.prefer32BitApks)
        val result = GithubConsumer.findLatestRelease(
            repository = GithubConsumer.GithubRepo("goastian", "midori-android", 0),
            isValidRelease = { !it.isPreRelease },
            isSuitableAsset = { name ->
                val n = name.name.lowercase()
                n.endsWith(".apk") && (AbiAssetMatcher.isApkFor(n, abi) ||
                        ABI.values().none { AbiAssetMatcher.isApkFor(n, it) })
            },
            requireReleaseDescription = false,
        )
        val version = result.tagName.removePrefix("v")
        return LatestVersion(
            downloadUrl = result.url,
            version = Version(version),
            publishDate = result.releaseDate,
            exactFileSizeBytesOfDownload = result.fileSizeBytes,
            fileHash = null,
        )
    }
}
