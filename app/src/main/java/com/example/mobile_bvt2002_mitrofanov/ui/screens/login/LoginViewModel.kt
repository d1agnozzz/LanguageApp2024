package com.example.mobile_bvt2002_mitrofanov.ui.screens.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.mobile_bvt2002_mitrofanov.common.EventHandler
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginSubstate
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(application: Application) : AndroidViewModel(application),
    EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState
    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> emailChanged(event.value)
            is LoginEvent.PasswordChanged -> passwordChanged(event.value)
            is LoginEvent.FirstNameChanged -> firstNameChanged(event.value)
            is LoginEvent.SecondNameChanged -> secondNameChanged(event.value)
            is LoginEvent.SignUpPasswordChanged -> signUpPasswordChanged(event.value)
            is LoginEvent.SignUpPasswordRepeatChanged -> signUppasswordRepeatChanged(event.value)
            LoginEvent.LoginClicked -> loginClicked()
            LoginEvent.ForgotClicked -> forgotClicked()
            LoginEvent.NotMemberClicked -> notMemberClicked()
            LoginEvent.AlreadyMemberClicked -> alreadyMemberClicked()
            LoginEvent.SignUpClicked -> signUpClicked()
            LoginEvent.ConfirmNameClicked -> confirmNameClicked()
        }
    }

    private fun notMemberClicked() {
        _viewState.value = _viewState.value.copy(
            LoginSubstate.AccountName
        )
    }

    private fun signUppasswordRepeatChanged(value: String) {
        _viewState.value = _viewState.value.copy(signUpPasswordRepeat = value)
    }

    private fun signUpPasswordChanged(value: String) {
        _viewState.value = _viewState.value.copy(signUpPassword = value)
    }

    private fun confirmNameClicked() {
        _viewState.value = _viewState.value.copy(loginSubstate = LoginSubstate.AccountPassword)
    }

    private fun alreadyMemberClicked() {
        _viewState.value = _viewState.value.copy(loginSubstate = LoginSubstate.Login)
    }

    private fun signUpClicked() {
        _viewState.value = _viewState.value.copy(isLoginSuccess = true)
    }

    private fun forgotClicked() {
        Log.e("NotImplemented", "ForgotPasswordScreen is not implemented")
    }

    private fun loginClicked() {
        _viewState.value = _viewState.value.copy(isLoginSuccess = true)
    }

    private fun secondNameChanged(value: String) {
        _viewState.value = _viewState.value.copy(secondNameText = value)
    }

    private fun firstNameChanged(value: String) {
        _viewState.value = _viewState.value.copy(firstNameText = value)
    }

    private fun passwordChanged(value: String) {
        _viewState.value = _viewState.value.copy(passwordText = value)
    }

    private fun emailChanged(value: String) {
        _viewState.value = _viewState.value.copy(emailText = value)
    }


}