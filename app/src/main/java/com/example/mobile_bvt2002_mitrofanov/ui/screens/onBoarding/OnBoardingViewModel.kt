package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.ON_BOARDING_PAGES
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingStage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(application: Application): AndroidViewModel(application),
    EventHandler<OnBoardingEvent> {
    private val _viewState = MutableStateFlow(OnBoardingStage())
    val viewState: StateFlow<OnBoardingStage> = _viewState

    override fun obtainEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.ContinueClicked -> continueClicked()
            is OnBoardingEvent.SkipClicked -> skipClicked()
        }

    }

    private fun continueClicked() {
        if (_viewState.value.stageNum + 1 < ON_BOARDING_PAGES) {
            _viewState.value = _viewState.value.copy(
                stageNum = _viewState.value.stageNum + 1
            )
        } else {
            _viewState.value = _viewState.value.copy(
                isOnBoardingFinished = true
            )

        }
    }

    private fun skipClicked() {
    }


}