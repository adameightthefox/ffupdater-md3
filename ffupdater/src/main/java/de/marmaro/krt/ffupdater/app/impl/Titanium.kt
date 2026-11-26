package de.marmaro.krt.ffupdater.app.impl

import android.content.Context
import android.os.Build
import androidx.annotation.Keep
import androidx.annotation.MainThread
import de.marmaro.krt.ffupdater.R
import de.marmaro.krt.ffupdater.app.App
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.BETTER_THAN_GOOGLE_CHROME
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.GOOD_PRIVACY_BROWSER
import de.marmaro.krt.ffupdater.app.entity.DisplayCategory.GOOD_SECURITY_BROWSER
import de.marmaro.krt.ffupdater.app.entity.LatestVersion
import de.marmaro.krt.ffupdater.app.entity.Version
import de.marmaro.krt.ffupdater.app.impl.base.AbiAssetMatcher
import de.marmaro.krt.ffupdater.device.ABI
import de.marmaro.krt.ffupdater.device.DeviceAbiExtractor
import de.marmaro.krt.ffupdater.network.exceptions.NetworkException
import de.marmaro.krt.ffupdater.network.github.GithubConsumer
import de.marmaro.krt.ffupdater.settings.DeviceSettingsHelper

/**
 * https://github.com/jqssun/android-titanium-browser
 * Formerly "Helium Browser for Android" (jqssun/android-helium-browser). It is NOT the official Helium
 * (imputnet/helium is desktop-only); the package name still contains "helium" for update compatibility.
 */
@Keep
object Titanium : AppBase() {
    override val app = App.TITANIUM
    override val packageName = "io.github.jqssun.helium"
    override val title = R.string.titanium__title
    override val description = R.string.titanium__description
    override val installationWarning = R.string.titanium__warning
    override val downloadSource = "GitHub"
    override val icon = R.drawable.ic_logo_titanium
    override val minApiLevel = Build.VERSION_CODES.O // TODO: verify against the APK (minSdkVersion)
    override val supportedAbis = listOf(ABI.ARM64_V8A, ABI.X86_64) // TODO: verify against release assets
    // TODO: replace with the SHA-256 of the signing certificate of the GitHub release APK.
    //  The GitHub and Google Play builds are meant to be update-compatible ("update between GitHub and Google Play").
    override val signatureHash = "095540494d53f48ca051bc86c392c46edb29725da5592bd8af3c3d027b3166bb"
    override val projectPage = "https://github.com/jqssun/android-titanium-browser"
    override val displayCategory = listOf(BETTER_THAN_GOOGLE_CHROME, GOOD_PRIVACY_BROWSER, GOOD_SECURITY_BROWSER)
    override val hostnameForInternetCheck = "https://api.github.com"

    @MainThread
    @Throws(NetworkException::class)
    override suspend fun fetchLatestUpdate(context: Context): LatestVersion {
        val abi = DeviceAbiExtractor.findBestAbi(supportedAbis, DeviceSettingsHelper.prefer32BitApks)
        val result = GithubConsumer.findLatestRelease(
            repository = GithubConsumer.GithubRepo("jqssun", "android-titanium-browser", 0),
            isValidRelease = { !it.isPreRelease },
            isSuitableAsset = { AbiAssetMatcher.isApkFor(it.name, abi) || isSingleUniversalApk(it.name) },
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

    /** some releases ship a single APK without architecture in its name */
    private fun isSingleUniversalApk(name: String): Boolean {
        val lower = name.lowercase()
        return lower.endsWith(".apk") && ABI.values().none { abi -> AbiAssetMatcher.isApkFor(lower, abi) }
    }
}
