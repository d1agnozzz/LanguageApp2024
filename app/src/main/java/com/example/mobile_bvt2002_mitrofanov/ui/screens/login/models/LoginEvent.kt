package com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models

sealed class LoginEvent {
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
    data class FirstNameChanged(val value: String) : LoginEvent()
    data class SecondNameChanged(val value: String) : LoginEvent()
    data class SignUpPasswordChanged(val value: String) : LoginEvent()
    data class SignUpPasswordRepeatChanged(val value: String) : LoginEvent()
    object ForgotClicked : LoginEvent()
    object LoginClicked : LoginEvent()
    object AlreadyMemberClicked : LoginEvent()
    object NotMemberClicked : LoginEvent()
    object ConfirmNameClicked : LoginEvent()
    object SignUpClicked : LoginEvent()
}