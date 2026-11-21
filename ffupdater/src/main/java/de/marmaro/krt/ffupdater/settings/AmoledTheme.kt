package de.marmaro.krt.ffupdater.settings

import android.app.Activity
import android.content.res.Configuration
import androidx.annotation.Keep
import de.marmaro.krt.ffupdater.R

/**
 * Optional pure black ("AMOLED") backgrounds for the dark theme.
 * Call [apply] at the beginning of Activity.onCreate(), before super.onCreate().
 */
@Keep
object AmoledTheme {
    fun apply(activity: Activity) {
        if (ForegroundSettings.isAmoledBlack && isNightModeActive(activity)) {
            activity.theme.applyStyle(R.style.ThemeOverlay_FFUpdater_Amoled, true)
        }
    }

    /** true if the pure black overlay would be used right now */
    fun isActive(activity: Activity): Boolean = ForegroundSettings.isAmoledBlack && isNightModeActive(activity)

    private fun isNightModeActive(activity: Activity): Boolean {
        val mask = activity.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return mask == Configuration.UI_MODE_NIGHT_YES
    }
}
