package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models.WordsEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.models.testVariantList
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun WordsScreen(
    viewModel: WordsViewModel,
    onNextClicked: () -> Unit
) {
    val viewState = viewModel.viewState.collectAsState()


    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 34.dp, bottom = 27.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            text = viewState.value.givenWord,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            modifier = Modifier.padding(bottom = 35.dp),
            text = viewState.value.givenPronunciation, color = when (isSystemInDarkTheme()) {
                true -> AppColors.White30
                else -> AppColors.Dark30
            },
            style = MaterialTheme.typography.bodySmall
        )
        Column {
            for ((i, testVariant) in testVariantList.withIndex()) {
                Button(
                    modifier = Modifier
                        .padding(bottom = 11.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (viewState.value.isAnswerSubmitted) {
                            false -> {
                                if (i == viewState.value.selectedTestVariant) {
                                    MaterialTheme.colorScheme.primary
                                } else if (isSystemInDarkTheme()) {
                                    AppColors.White30

                                } else {
                                    AppColors.GrayLight
                                }
                            }

                            true -> {
                                when (i) {
                                    viewState.value.correctTestVariant -> AppColors.Green
                                    viewState.value.selectedTestVariant -> AppColors.Orange
                                    else -> if (isSystemInDarkTheme()) {
                                        AppColors.White30
                                    } else {
                                        AppColors.GrayLight
                                    }
                                }

                            }
                        }
                    ),
                    shape = RoundedCornerShape(16.dp),
                    onClick = { viewModel.obtainEvent(WordsEvent.TestVariantSelected(i)) }
                ) {
                    Text(
                        text = testVariant.label,
                        color = when (viewState.value.isAnswerSubmitted) {
                            false -> {
                                if (i == viewState.value.selectedTestVariant) {
                                    AppColors.White
                                } else {
                                    MaterialTheme.colorScheme.onBackground
                                }

                            }

                            true -> {
                                when (i) {
                                    viewState.value.correctTestVariant -> AppColors.Dark
                                    viewState.value.selectedTestVariant -> AppColors.White
                                    else -> MaterialTheme.colorScheme.onBackground
                                }
                            }
                        },
                        style = MaterialTheme.typography.labelMedium
                    )

                }
            }

        }
        Spacer(modifier = Modifier.weight(1f))
        FilledButton(
            onClick = {
                when (viewState.value.isAnswerSubmitted) {
                    false -> viewModel.obtainEvent(WordsEvent.checkClicked)
                    true -> onNextClicked()
                }
            },
            label = when (viewState.value.isAnswerSubmitted) {
                false -> R.string.wordsCheckButtonLabel
                true -> R.string.quizNextButtonLabel
            }
        )
    }


}