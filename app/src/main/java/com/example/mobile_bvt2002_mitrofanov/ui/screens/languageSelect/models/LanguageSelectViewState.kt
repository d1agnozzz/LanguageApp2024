package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models

enum class Language {
    Russian, English, Chinese, Belarus, Kazakh
}

data class LanguageSelectViewState(
    val selectedLanguage: Language = Language.Russian,
    val isLanguageSelectionFinished: Boolean = false,
)
