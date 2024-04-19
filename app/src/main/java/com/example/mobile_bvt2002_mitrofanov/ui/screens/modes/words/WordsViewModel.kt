package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models.WordsEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models.WordsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(application: Application) : AndroidViewModel(application),
    EventHandler<WordsEvent> {
    private val _viewState = MutableStateFlow(WordsViewState())
    val viewState: StateFlow<WordsViewState> = _viewState


    override fun obtainEvent(event: WordsEvent) {
        when (event) {
            is WordsEvent.TestVariantSelected -> testVariantSelected(event.value)
            WordsEvent.checkClicked -> checkClicked()
        }

    }

    private fun checkClicked() {
        if (viewState.value.selectedTestVariant != null) {
            _viewState.value = _viewState.value.copy(
                isAnswerSubmitted = true
            )
        }
    }

    private fun testVariantSelected(value: Int) {
        _viewState.value = _viewState.value.copy(
            selectedTestVariant = value
        )
    }


}