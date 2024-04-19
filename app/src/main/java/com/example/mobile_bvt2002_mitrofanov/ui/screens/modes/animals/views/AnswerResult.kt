package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton

@Composable
fun AnswerResult(
    isAnswerCorrect: Boolean,
    @DrawableRes image: Int,
    @StringRes title: Int,
    correctAnswer: String,
    onNextClicked: () -> Unit,
    onRetryClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(332.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(bottom = 48.dp)
                .size(160.dp),
            painter = painterResource(id = image),
            contentDescription = ""
        )
        Text(
            text = stringResource(id = title) + correctAnswer,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
    }
    Column(modifier = Modifier.fillMaxSize()) {
        FilledButton(onClick = { onNextClicked() }, label = R.string.quizNextButtonLabel)
        Spacer(modifier = Modifier.height(11.dp))
        if (!isAnswerCorrect) {
            FilledButton(onClick = { onRetryClicked() }, label = R.string.quizTryAgainButtonLabel)

        }


    }
}