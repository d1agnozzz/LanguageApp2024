package com.example.mobile_bvt2002_mitrofanov.ui.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(application: Application): AndroidViewModel(application), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState
    override fun obtainEvent(event: LoginEvent) {
        TODO("Not yet implemented")
    }


}