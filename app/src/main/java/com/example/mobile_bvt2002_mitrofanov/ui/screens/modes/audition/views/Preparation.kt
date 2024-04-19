package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views

import androidx.compose.runtime.Composable
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton

@Composable
fun Preparation(
    onCheckClicked: () -> Unit
) {

    FilledButton(onClick = { onCheckClicked() }, label = R.string.auditionCheckButtonLabel)
}