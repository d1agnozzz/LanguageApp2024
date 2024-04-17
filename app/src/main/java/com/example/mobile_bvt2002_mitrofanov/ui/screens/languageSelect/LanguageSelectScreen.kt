package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.views.LanguageSelectView

@Composable
fun LanguageSelectScreen(
    onBoardingViewModel: LanguageSelectViewModel,
    onLanguageSelectFinish: () -> Unit,
) {
    val viewState = onBoardingViewModel.viewState.collectAsState()

    with(viewState.value) {
        LanguageSelectView(
            this@with,
            onLanguageSelect = { language ->
                onBoardingViewModel.obtainEvent(
                    LanguageSelectEvent.LanguageSelected(language)
                )
            },
            onChooseClicked = {
                onBoardingViewModel.obtainEvent(
                    LanguageSelectEvent.ChooseClicked
                )
            }
            )
    }
}