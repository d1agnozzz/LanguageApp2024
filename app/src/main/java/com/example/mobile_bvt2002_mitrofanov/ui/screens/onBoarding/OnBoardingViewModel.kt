package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(application: Application): AndroidViewModel(application){
    private val _viewState = MutableStateFlow(OnBoardingViewState())
    val viewState: StateFlow<OnBoardingViewState> = _viewState

    val context = application.applicationContext


}