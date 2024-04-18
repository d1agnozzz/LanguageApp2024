package com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginViewState
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun AccountPassword(
    viewState: LoginViewState,
    onSignUpPasswordChange: (String) -> Unit,
    onSignUpPasswordRepeatChange: (String) -> Unit,
    onSignUpClicked: () -> Unit,
    onAlreadyMemberClicked: () -> Unit,
) {

    Text(
        modifier = Modifier.padding(bottom = 32.dp),
        text = stringResource(id = R.string.choosePasswordTitle),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineMedium
    )

    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.passwordFieldLabel),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(
                text = "●●●●●",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        value = viewState.signUpPassword,
        onValueChange = {
            onSignUpPasswordChange(it)
        },
        secureText = true
    )

    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.confirmPasswordLabel),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(
                text = "●●●●●",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        value = viewState.signUpPasswordRepeat,
        onValueChange = {
            onSignUpPasswordRepeatChange(it)
        },
        secureText = true
    )

    FilledButton( onClick = { onSignUpClicked() }) {
        Text(
            text = stringResource(id = R.string.signUpButtonLabel),
            color = AppColors.White,
            style = MaterialTheme.typography.headlineMedium
        )

    }
    Spacer(modifier = Modifier.height(24.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.alreadyOurMember),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.clickable(onClick = { onAlreadyMemberClicked() }),
            text = stringResource(id = R.string.signIn),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}