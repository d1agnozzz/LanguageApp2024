package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R

@Composable
fun GivenTask(
    givenWord: String,
    givenPronunciation: String,
) {
    Text(
        text = givenWord,
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.labelMedium,
    )
    Text(
        modifier = Modifier.padding(bottom = 68.dp),
        text = givenPronunciation,
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.bodySmall,
    )
    Text(
        modifier = Modifier.padding(bottom = 9.dp),
        text = stringResource(id = R.string.auditionPreparationLabel),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.labelMedium,
    )

}