package com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models

sealed class MainEvent {
    object userClicked : MainEvent()
    object guessTheAnimalClicked : MainEvent()
    object wordPracticeClicked : MainEvent()
    object auditionClicked : MainEvent()
    object gameClicked : MainEvent()

}