package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models

enum class AuditionSubState {
    Preparation, Pronunciation, Success
}

data class AuditionViewState(
    val givenWord: String = "cucumber",
    val givenPronunciation: String = "[ 'kju:kʌmbə ]",
    val auditionSubState: AuditionSubState = AuditionSubState.Preparation,
)