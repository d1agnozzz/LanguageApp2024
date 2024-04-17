package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingViewState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.views.OnBoardingView

@Composable
fun OnBoardingScreen(
    onBoardingViewModel: OnBoardingViewModel,
    onOnBoardingFinished: () -> Unit,
) {
    val viewState = onBoardingViewModel.viewState.collectAsState()

    val isDarkMode = isSystemInDarkTheme()
    val statusNavigationBar = colorScheme.background

    val local_view = LocalView.current

    // change system bars color with light/dark theme change
    SideEffect {
        val activity = (local_view.context as Activity)
        activity.window.statusBarColor = statusNavigationBar.toArgb()
        activity.window.navigationBarColor = statusNavigationBar.toArgb()

        val window_compat = WindowCompat.getInsetsController(activity.window, local_view)
        window_compat.isAppearanceLightStatusBars = !isDarkMode
        window_compat.isAppearanceLightNavigationBars = !isDarkMode
    }



    with(viewState.value) {
        OnBoardingView(
            viewState = this,
            onContinueClicked = { onBoardingViewModel.obtainEvent(OnBoardingEvent.ContinueClicked) },
            onSkipClicked = { onBoardingViewModel.obtainEvent(OnBoardingEvent.SkipClicked) })
    }
}