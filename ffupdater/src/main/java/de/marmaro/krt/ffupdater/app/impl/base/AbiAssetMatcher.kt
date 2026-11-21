package de.marmaro.krt.ffupdater.app.impl.base

import de.marmaro.krt.ffupdater.device.ABI

/**
 * Helper for projects that publish several APKs per release (one per CPU architecture) and whose
 * file names are not fixed. It matches the APK name against well-known ABI spellings.
 */
object AbiAssetMatcher {
    private fun spellings(abi: ABI): List<String> = when (abi) {
        ABI.ARM64_V8A -> listOf("arm64-v8a", "arm64_v8a", "arm64", "aarch64")
        ABI.ARMEABI_V7A -> listOf("armeabi-v7a", "armeabi_v7a", "arm32", "armv7", "arm")
        ABI.X86_64 -> listOf("x86_64", "x86-64", "x64", "amd64")
        ABI.X86 -> listOf("x86", "i386", "i686")
        else -> emptyList()
    }

    /** true if [fileName] is an APK built for [abi] and not for a more specific/other ABI */
    fun isApkFor(fileName: String, abi: ABI): Boolean {
        val name = fileName.lowercase()
        if (!name.endsWith(".apk")) return false
        val tokens = name.removeSuffix(".apk").split('-', '_', '.', ' ').filter { it.isNotEmpty() }
        val joined = name
        return when (abi) {
            // "arm" must not match "arm64"; "x86" must not match "x86_64"
            ABI.ARMEABI_V7A -> spellings(abi).any { s -> if (s == "arm") "arm" in tokens else s in joined } &&
                    !isApkFor(fileName, ABI.ARM64_V8A)
            ABI.X86 -> spellings(abi).any { s -> s in tokens } && !joined.contains("x86_64") && !joined.contains("x86-64")
            else -> spellings(abi).any { it in joined }
        }
    }
}
