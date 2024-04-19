package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalSubstate
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalsViewState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.correctAnswer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AnimalsViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application), EventHandler<AnimalEvent> {
    private val _viewState = MutableStateFlow(AnimalsViewState())
    val viewState: StateFlow<AnimalsViewState> = _viewState
    override fun obtainEvent(event: AnimalEvent) {
        when (event) {
            is AnimalEvent.AnswerTextChanged -> answerTextChanged(event.value)
            AnimalEvent.CheckClicked -> checkClicked()
            AnimalEvent.RetryClicked -> retryClicked()
        }
    }

    private fun retryClicked() {
        _viewState.value = _viewState.value.copy(
            animalSubstate = AnimalSubstate.Quiz
        )
    }

    private fun checkClicked() {
        if (_viewState.value.answerText.lowercase().trim() == correctAnswer) {
            _viewState.value = _viewState.value.copy(animalSubstate = AnimalSubstate.CorrectAnswer)
        } else {
            _viewState.value = _viewState.value.copy(animalSubstate = AnimalSubstate.WrongAnswer)

        }


    }

    private fun answerTextChanged(value: String) {
        _viewState.value = _viewState.value.copy(
            answerText = value
        )
    }

}