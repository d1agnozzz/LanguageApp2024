package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingViewState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.views.OnBoardingView

@Composable
fun OnBoardingScreen(
    onBoardingViewModel: OnBoardingViewModel,
    onContinueClicked: () -> Unit,
    onSkipClicked: () -> Unit,
) {
    val viewState = onBoardingViewModel.viewState.collectAsState(OnBoardingViewState())

    with(viewState.value) {
        OnBoardingView(viewState = this)
    }
    
    Text(text = "Hello, world!", color = Color.Cyan)
}