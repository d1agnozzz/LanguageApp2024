package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalSubstate
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.correctAnswer
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.views.AnswerResult
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.views.Quiz

@Composable
fun AnimalsScreen(
    viewModel: AnimalsViewModel,
    onNextClicked: () -> Unit,
) {
    val viewState = viewModel.viewState.collectAsState()

    with(viewState.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(vertical = 16.dp)
        ) {
            when (viewState.value.animalSubstate) {
                AnimalSubstate.Quiz -> Quiz(
                    image = R.drawable.racoon,
                    answerText = viewState.value.answerText,
                    onAnswerTextChange = { viewModel.obtainEvent(AnimalEvent.AnswerTextChanged(it)) },
                    onCheckClicked = { viewModel.obtainEvent(AnimalEvent.CheckClicked) })

                AnimalSubstate.CorrectAnswer -> {
                    AnswerResult(
                        isAnswerCorrect = true,
                        image = R.drawable.congrats,
                        title = R.string.correctAnswerCongrats,
                        onNextClicked = { onNextClicked() },
                        correctAnswer = correctAnswer,
                        onRetryClicked = {}
                    )


                }

                AnimalSubstate.WrongAnswer -> {
                    AnswerResult(
                        isAnswerCorrect = false,
                        image = R.drawable.sad_cat,
                        title = R.string.wrondAnswerTitle,
                        onNextClicked = { onNextClicked() },
                        correctAnswer = correctAnswer,
                        onRetryClicked = { viewModel.obtainEvent(AnimalEvent.RetryClicked) }
                    )
                }
            }

        }
    }

}