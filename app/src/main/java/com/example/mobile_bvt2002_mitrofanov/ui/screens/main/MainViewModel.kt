package com.example.mobile_bvt2002_mitrofanov.ui.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.MainEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.MainViewState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.topUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application),
    EventHandler<MainEvent> {
    private val _viewState = MutableStateFlow(
        MainViewState(
            userName = R.string.userName,
            topUsers = topUsers,
            userImage = R.drawable.user_image
        )
    )
    val viewState: StateFlow<MainViewState> = _viewState
    override fun obtainEvent(event: MainEvent) {
        when (event) {
            MainEvent.auditionClicked -> auditionClicked()
            MainEvent.gameClicked -> gameClicked()
            MainEvent.guessTheAnimalClicked -> guessTheAnimalClicked()
            MainEvent.userClicked -> userClicked()
            MainEvent.wordPracticeClicked -> wordPracticeClicked()
        }
    }

    private fun wordPracticeClicked() {
        TODO("Not yet implemented")
    }

    private fun userClicked() {
    }

    private fun guessTheAnimalClicked() {
        TODO("Not yet implemented")
    }

    private fun gameClicked() {
        TODO("Not yet implemented")
    }

    private fun auditionClicked() {
        TODO("Not yet implemented")
    }
}