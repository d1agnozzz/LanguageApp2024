package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models.AuditionEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models.AuditionSubState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models.AuditionViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuditionViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application), EventHandler<AuditionEvent> {
    private val _viewState = MutableStateFlow(AuditionViewState())
    val viewState: StateFlow<AuditionViewState> = _viewState
    override fun obtainEvent(event: AuditionEvent) {
        when (event) {
            AuditionEvent.checkClicked -> checkClicked()
            AuditionEvent.microphoneClicked -> microphoneClicked()
        }
    }

    private fun microphoneClicked() {
        _viewState.value = _viewState.value.copy(
            auditionSubState = AuditionSubState.Success
        )
    }

    private fun checkClicked() {
        _viewState.value = _viewState.value.copy(
            auditionSubState = AuditionSubState.Pronunciation
        )
    }

}