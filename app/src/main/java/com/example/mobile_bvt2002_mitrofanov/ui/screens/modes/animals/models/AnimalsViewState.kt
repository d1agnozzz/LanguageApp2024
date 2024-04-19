package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models

enum class AnimalSubstate {
    Quiz, CorrectAnswer, WrongAnswer
}

data class AnimalsViewState(
    val answerText: String = "",
    val animalSubstate: AnimalSubstate = AnimalSubstate.Quiz,
    val isAnswerCorrect: Boolean? = null
)

val correctAnswer = "racoon"