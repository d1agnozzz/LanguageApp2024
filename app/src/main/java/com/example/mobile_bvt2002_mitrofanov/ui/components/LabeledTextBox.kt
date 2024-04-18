package com.example.mobile_bvt2002_mitrofanov.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun LabeledTextBox(
    label: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    secureText: Boolean = false,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var showPassword = remember {
        mutableStateOf(false)
    }

    Column {
        label()
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            singleLine = true,
            trailingIcon = {
                           if (secureText) {
                               Box(modifier = Modifier.clickable {
                                   showPassword.value = !showPassword.value
                               }) {
                                   Icon(painter = painterResource(id = R.drawable.visibility_icon), contentDescription = "toggle password")
                               }
                           }
            },
            shape = RoundedCornerShape(12.dp),
            colors = if (!isSystemInDarkTheme()) {
                TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = AppColors.Dark05,
                    unfocusedContainerColor = AppColors.Dark05,
                    unfocusedPlaceholderColor = AppColors.Dark20,
                    focusedPlaceholderColor = AppColors.Dark

                )

            } else {
                TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = AppColors.White05,
                    unfocusedContainerColor = AppColors.White05,
                    unfocusedPlaceholderColor = AppColors.White20,
                    focusedPlaceholderColor = AppColors.White30

                )

            },
            enabled = enabled,
            isError = isError,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            visualTransformation = if (secureText) PasswordVisualTransformation() else VisualTransformation.None,
        )

    }

}