package com.example.mobile_bvt2002_mitrofanov.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors.Blue
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors.Dark
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors.Orange
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors.White


private val DarkColorScheme = darkColorScheme(
        primary = Blue,
        onPrimary = White,

        secondary = Orange,
        onSecondary = Dark,

        error = Orange,
        onError = White,

        background = Dark,
        onBackground = White,

)

private val LightColorScheme = lightColorScheme(
        primary = Blue,
        onPrimary = White,

        secondary = Orange,
        onSecondary = Dark,

        error = Orange,
        onError = White,

        background = White,


        /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MobileBVT2002MitrofanovTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        // Dynamic color is available on Android 12+
        dynamicColor: Boolean = false,
        content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = AppColors.DeepBlue.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()

            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = false
            insetsController.isAppearanceLightNavigationBars = !darkTheme

        }
    }

    MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
    )
}