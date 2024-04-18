package com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models

enum class LoginSubstate {
    Login,
    AccountName,
    AccountPassword
}

data class LoginViewState(
    val loginSubstate: LoginSubstate = LoginSubstate.Login,
    val emailText: String = "",
    val passwordText: String = "",
    val firstNameText: String = "",
    val secondNameText: String = "",
    val signUpPassword: String = "",
    val signUpPasswordRepeat: String = "",
    val isLoginSuccess: Boolean = false,
)