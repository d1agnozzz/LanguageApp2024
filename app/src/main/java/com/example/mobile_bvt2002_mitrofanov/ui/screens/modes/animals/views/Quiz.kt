package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.components.LabeledTextBox

@Composable
fun Quiz(
    @DrawableRes image: Int,
    answerText: String,
    onAnswerTextChange: (String) -> Unit,
    onCheckClicked: () -> Unit
) {
    Image(
        modifier = Modifier
            .padding(bottom = 17.dp)
            .fillMaxWidth()
            .height(328.dp)
            .clip(RoundedCornerShape(20.dp)),

        painter = painterResource(id = image),
        contentDescription = "quiz image",
        contentScale = ContentScale.Crop
    )
    LabeledTextBox(
        modifier = Modifier
            .padding(bottom = 17.dp)
            .fillMaxWidth(),
        label = R.string.quizTaskLabel,
        placeholder = R.string.quizFieldPlaceholed,
        value = answerText,
        onValueChange = { onAnswerTextChange(it) }
    )
    FilledButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = { onCheckClicked() },
        label = R.string.quizCheckButtonLabel
    )


}