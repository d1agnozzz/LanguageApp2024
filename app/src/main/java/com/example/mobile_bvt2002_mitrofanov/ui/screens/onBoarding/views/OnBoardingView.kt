package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingViewState

@Composable
fun OnBoardingView(
    viewState: OnBoardingViewState,
) {
    with (viewState) {
        Text("OnBoarding Screen!")
    }
}