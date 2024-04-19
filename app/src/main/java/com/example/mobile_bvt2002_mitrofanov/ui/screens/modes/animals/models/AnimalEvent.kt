package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models

sealed class AnimalEvent {
    data class AnswerTextChanged(val value: String) : AnimalEvent()
    object CheckClicked : AnimalEvent()
    object RetryClicked : AnimalEvent()
}