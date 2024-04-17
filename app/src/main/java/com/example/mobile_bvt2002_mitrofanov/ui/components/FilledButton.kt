package com.example.mobile_bvt2002_mitrofanov.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilledButton(
    modifier: Modifier = Modifier.fillMaxWidth().height(56.dp),
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable () -> Unit,
) {
    Button(modifier = modifier, onClick = onClick, colors = colors, shape = RoundedCornerShape(16.dp)) {
        content()
    }

}