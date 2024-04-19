package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models

sealed class WordsEvent {
    data class TestVariantSelected(val value: Int) : WordsEvent()
    object checkClicked : WordsEvent()
}