package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models


data class WordsViewState(
    val givenWord: String = "gardener",
    val givenPronunciation: String = "[ 'gɑ:dnə ]",
    val selectedTestVariant: Int? = null,
    val correctTestVariant: Int = 1,
    val isAnswerSubmitted: Boolean = false,
)

data class TestVariant(
    val label: String
)

val testVariantList = listOf(
    TestVariant(
        label = "Муха"
    ),
    TestVariant(
        label = "Садовник"
    ),
    TestVariant(
        label = "Гладиолус"
    ),
    TestVariant(
        label = "Собака"
    )
)