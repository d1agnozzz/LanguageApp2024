package com.example.mobile_bvt2002_mitrofanov.ui.screens.login.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.models.LoginViewState
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun SignInView(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onForgetClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    onNotMemberClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .height(82.dp)
                .width(105.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(bottom = 12.dp),

                painter = painterResource(id = R.drawable.login_image),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )

        }
        Text(
            modifier = Modifier.padding(bottom = 32.dp),
            text = stringResource(id = R.string.loginTitle),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )


    }
    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        label = R.string.emailFieldLabel,
        placeholder = R.string.emailFieldPlaceholder,
        value = viewState.emailText,
        onValueChange = {
            onEmailChanged(it)
        }
    )
    LabeledTextBox(
        modifier = Modifier.fillMaxWidth(),
        label = R.string.passwordFieldLabel,
        placeholder = R.string.passwordFieldPlaceholder,
        secureText = true,
        value = viewState.passwordText,
        onValueChange = {
            onPasswordChanged(it)
        }
    )

    Box(
        modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth()
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.forgotPassword),
                color = AppColors.Red,
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }
    FilledButton(onClick = { onLoginClicked() }, label = R.string.loginButtonTitle)
    Spacer(modifier = Modifier.height(24.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.loginNotOurMember),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier.clickable(onClick = { onNotMemberClicked() }),
            text = stringResource(id = R.string.signUp),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}
