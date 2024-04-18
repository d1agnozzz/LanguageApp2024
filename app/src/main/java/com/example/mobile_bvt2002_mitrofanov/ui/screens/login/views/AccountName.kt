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
fun AccountName (
    viewState: LoginViewState,
    onEmailChange: (String) -> Unit,
    onFirstNameChange: (String) ->Unit,
    onSecondNameChange: (String) -> Unit,
    onConfirmNameClicked: () -> Unit,
    onAlreadyMemberClicked: () -> Unit,
) {
    Text(
        modifier = Modifier.padding(bottom = 32.dp),
        text = stringResource(id = R.string.createAccountTitle),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineMedium
    )

    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.firstNameTextFieldLabel),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(

                text = stringResource(id = R.string.firstNameTextFieldPlaceholder),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        value = viewState.firstNameText,
        onValueChange = {
            onFirstNameChange(it)
        }
    )

    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.secondNameTextFieldLabel),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.secondNameTextFieldPlaceholder),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        value = viewState.secondNameText,
        onValueChange = {
            onSecondNameChange(it)
        }
    )
    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 34.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = stringResource(id = R.string.emailFieldLabel),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        placeholder = {
            Text(
                text = "Email",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        value = viewState.emailText,
        onValueChange = {
            onEmailChange(it)
        }
    )
    FilledButton(onClick = { onConfirmNameClicked() }) {
        Text(
            text = stringResource(id = R.string.confirmNameButtonLabel),
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