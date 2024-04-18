package com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox

@Composable
fun CreateAccount() {
    Text(
        modifier = Modifier.padding(bottom = 32.dp),
        text = stringResource(id = R.string.createAccountTitle),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineMedium
    )

    LabeledTextBox(
        modifier = Modifier.fillMaxWidth(),
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
        value = "",
        onValueChange = {}
    )

    LabeledTextBox(
        modifier = Modifier.fillMaxWidth(),
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
        value = "",
        onValueChange = {}
    )


}