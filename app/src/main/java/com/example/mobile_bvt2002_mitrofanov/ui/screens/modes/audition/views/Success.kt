package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox

@Composable
fun Success(
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LabeledTextBox(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth(),
            label = R.string.auditionYourResult,
            placeholder = R.string.auditionResultPlaceholer,
            value = "cucumber",
            onValueChange = {}
        )
        FilledButton(onClick = { onNextClick() }, label = R.string.auditionNextButton)
    }

}