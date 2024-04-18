package com.example.mobile_bvt2002_mitrofanov.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.TopBarWithBackButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginSubstate
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views.AccountName
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views.AccountPassword
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views.SignInView
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onLoginSuccess: () -> Unit,
    onBackClicked: () -> Unit
) {

    val viewState = loginViewModel.viewState.collectAsState()

    LaunchedEffect(key1 = viewState.value.isLoginSuccess) {
        when (viewState.value.isLoginSuccess) {
            true -> onLoginSuccess()
            else -> {}
        }

    }

    with(viewState.value) {
        Scaffold(
            topBar = {
                TopBarWithBackButton(
                    title = {
                        Text(
                            text = when (this.loginSubstate) {
                                LoginSubstate.Login -> stringResource(id = R.string.loginHeader)
                                else -> stringResource(id = R.string.accountNameHeader)
                            },
                            color = AppColors.White,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    },
                    onBackClick = {
                        onBackClicked()
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxSize(),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (viewState.value.loginSubstate) {
                        LoginSubstate.Login -> SignInView(
                            viewState = this@with,
                            onEmailChanged = {
                                loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                            },
                            onPasswordChanged = {
                                loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                            },
                            onForgetClicked = {
                                loginViewModel.obtainEvent(LoginEvent.ForgotClicked)
                            },
                            onLoginClicked = {
                                loginViewModel.obtainEvent(LoginEvent.LoginClicked)
                            },
                            onNotMemberClicked = {
                                loginViewModel.obtainEvent(LoginEvent.NotMemberClicked)
                            })

                        LoginSubstate.AccountName -> AccountName(
                            viewState = this@with,
                            onEmailChange = {
                                loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                            },
                            onFirstNameChange = {
                                loginViewModel.obtainEvent(LoginEvent.FirstNameChanged(it))
                            },
                            onSecondNameChange = {
                                loginViewModel.obtainEvent(LoginEvent.SecondNameChanged(it))
                            },
                            onConfirmNameClicked = {
                                loginViewModel.obtainEvent(LoginEvent.ConfirmNameClicked)
                            },
                            onAlreadyMemberClicked = {
                                loginViewModel.obtainEvent(LoginEvent.AlreadyMemberClicked)
                            }
                        )

                        LoginSubstate.AccountPassword -> AccountPassword(
                            viewState = this@with,
                            onSignUpPasswordChange = {
                                loginViewModel.obtainEvent(LoginEvent.SignUpPasswordChanged(it))
                            },
                            onSignUpPasswordRepeatChange = {
                                loginViewModel.obtainEvent(LoginEvent.SignUpPasswordRepeatChanged(it))
                            },
                            onSignUpClicked = {
                                loginViewModel.obtainEvent(LoginEvent.SignUpClicked)

                            },
                            onAlreadyMemberClicked = {
                                loginViewModel.obtainEvent(LoginEvent.AlreadyMemberClicked)
                            }
                        )

                    }

                }

            }

        }
    }

}