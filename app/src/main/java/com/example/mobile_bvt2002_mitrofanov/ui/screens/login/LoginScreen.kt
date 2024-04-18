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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.TopBarWithBackButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views.CreateAccount
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
) {

    val viewState = loginViewModel.viewState.collectAsState()

    with(viewState.value) {
        Scaffold(
            topBar = {
                TopBarWithBackButton(
                    title = {
                        Text(
                            text = stringResource(id = R.string.loginHeader),
                            color = AppColors.White,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    },
                    onBackClick = {

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
                    CreateAccount()

                }

            }

        }
    }

}