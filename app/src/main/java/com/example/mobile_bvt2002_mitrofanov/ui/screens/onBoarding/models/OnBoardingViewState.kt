package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models

enum class OnBoardingStage {
    First, Second, Third
}

data class OnBoardingViewState(
    val onBoardingStage: OnBoardingStage = OnBoardingStage.First,
)