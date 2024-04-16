package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models

sealed class OnBoardingEvent {
    object ContinueClicked : OnBoardingEvent()
    object SkipClicked : OnBoardingEvent()
}