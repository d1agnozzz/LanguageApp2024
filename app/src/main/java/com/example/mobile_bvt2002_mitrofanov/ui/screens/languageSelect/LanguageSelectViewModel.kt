package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.data.onBoardingDataStore
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.Language
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LanguageSelectViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application), EventHandler<LanguageSelectEvent> {

    private val _viewState = MutableStateFlow(LanguageSelectViewState())
    val viewState: StateFlow<LanguageSelectViewState> = _viewState

    private val context =   application.applicationContext

    private suspend fun updateOnBoardingFlag(value: Boolean) {
        context.onBoardingDataStore.updateData { currentValue ->
            currentValue.toBuilder().setShowOnboarding(value).build()
        }
    }

    private fun selectLanguage(language: Language) {
        _viewState.value = _viewState.value.copy(language)
    }

    private fun onChooseClicked() {
        TODO("Not yet implemented")
    }

    override fun obtainEvent(event: LanguageSelectEvent) {
        when (event) {
            is LanguageSelectEvent.LanguageSelected -> selectLanguage(event.language)
            LanguageSelectEvent.ChooseClicked -> onChooseClicked()
        }
    }


}
