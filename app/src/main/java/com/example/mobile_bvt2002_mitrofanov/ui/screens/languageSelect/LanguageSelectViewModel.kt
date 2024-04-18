package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.data.LanguageProto
import com.example.mobile_bvt2002_mitrofanov.data.languageSelectedDataStore
import com.example.mobile_bvt2002_mitrofanov.data.onBoardingDataStore
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.Language
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageSelectViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application), EventHandler<LanguageSelectEvent> {

    private val _viewState = MutableStateFlow(LanguageSelectViewState())
    val viewState: StateFlow<LanguageSelectViewState> = _viewState

    @ApplicationContext private val context =   application.applicationContext

    private suspend fun updateOnBoardingFlag(value: Boolean) {
        context.onBoardingDataStore.updateData { currentValue ->
            currentValue.toBuilder().setShowOnboarding(value).build()
        }
    }

    private suspend fun updateLanguageSelected(value: Language) {

        val language_proto = when (value) {
            Language.Russian -> LanguageProto.RUSSIAN
            Language.English -> LanguageProto.ENGLISH
            Language.Chinese -> LanguageProto.CHINESE
            Language.Belarus -> LanguageProto.BELARUS
            Language.Kazakh -> LanguageProto.KAZAKH
        }

        context.languageSelectedDataStore.updateData { currentValue ->
            currentValue.toBuilder().setLanguage(language_proto).build()
        }
    }

    private fun selectLanguage(language: Language) {
        _viewState.value = _viewState.value.copy(language)
    }

    private fun onChooseClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            updateOnBoardingFlag(false)
            updateLanguageSelected(_viewState.value.selectedLanguage)
            _viewState.value = _viewState.value.copy(isLanguageSelectionFinished = true)
        }

    }

    override fun obtainEvent(event: LanguageSelectEvent) {
        when (event) {
            is LanguageSelectEvent.LanguageSelected -> selectLanguage(event.language)
            LanguageSelectEvent.ChooseClicked -> onChooseClicked()
        }
    }


}
