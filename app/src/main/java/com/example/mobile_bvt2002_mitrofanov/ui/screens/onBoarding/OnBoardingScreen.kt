package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.views.OnBoardingView
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun OnBoardingScreen(
    onBoardingViewModel: OnBoardingViewModel,
    onOnBoardingFinished: () -> Unit,
) {
    val viewState = onBoardingViewModel.viewState.collectAsState()

    val isDarkMode = isSystemInDarkTheme()
    val statusNavigationBarColor = colorScheme.background
    val backgroundColor = colorScheme.background

    val local_view = LocalView.current

    // change system bars color with light/dark theme change


    with(viewState.value) {
        LaunchedEffect(key1 = this.isOnBoardingFinished) {
            when (isOnBoardingFinished) {
                // make system bars transparrent for onboarding
                false -> {
                    val activity = (local_view.context as Activity)
                    activity.window.statusBarColor = statusNavigationBarColor.toArgb()
                    activity.window.navigationBarColor = statusNavigationBarColor.toArgb()

                    val window_compat =
                        WindowCompat.getInsetsController(activity.window, local_view)
                    window_compat.isAppearanceLightStatusBars = !isDarkMode
                    window_compat.isAppearanceLightNavigationBars = !isDarkMode
                }

                // change system bars colors back to default
                true -> {
                    val activity = (local_view.context as Activity)
                    activity.window.statusBarColor = AppColors.DeepBlue.toArgb()
                    activity.window.navigationBarColor = backgroundColor.toArgb()

                    val window_compat =
                        WindowCompat.getInsetsController(activity.window, local_view)
                    window_compat.isAppearanceLightStatusBars = false
                    window_compat.isAppearanceLightNavigationBars = !isDarkMode

                }
            }
        }

        OnBoardingView(
            viewState = this,
            onContinueClicked = { onBoardingViewModel.obtainEvent(OnBoardingEvent.ContinueClicked) },
            onSkipClicked = { onBoardingViewModel.obtainEvent(OnBoardingEvent.SkipClicked) })

        val backgroundColor = MaterialTheme.colorScheme.background
        LaunchedEffect(key1 = this.isOnBoardingFinished) {
            when (isOnBoardingFinished) {
                true -> {
                    onOnBoardingFinished()
                }

                else -> Unit
            }

        }
    }
}