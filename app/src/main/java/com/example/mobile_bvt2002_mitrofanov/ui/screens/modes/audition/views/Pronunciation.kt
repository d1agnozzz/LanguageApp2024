package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun Pronunciation(
    onMicClicked: () -> Unit

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LabeledTextBox(
            modifier = Modifier.fillMaxWidth(),
            label = R.string.auditionYourResult,
            placeholder = R.string.auditionResultPlaceholer,
            value = "pupumber",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.size(160.dp),
            onClick = { onMicClicked() },
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.Green
            ),
            shape = RoundedCornerShape(50.dp),

            ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.mic),
                contentDescription = "microphone"
            )

        }

    }

}