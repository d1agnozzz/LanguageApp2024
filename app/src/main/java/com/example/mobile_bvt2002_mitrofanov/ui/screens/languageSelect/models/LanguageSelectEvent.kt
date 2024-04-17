package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models

sealed class LanguageSelectEvent {

    data class LanguageSelected(val language: Language) : LanguageSelectEvent()
    object ChooseClicked : LanguageSelectEvent()
}