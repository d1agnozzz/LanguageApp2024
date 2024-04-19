package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models.AuditionEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models.AuditionSubState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views.GivenTask
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views.Preparation
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views.Pronunciation
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.views.Success

@Composable
fun AuditionScreen(
    viewModel: AuditionViewModel,
    onNextClicked: () -> Unit,
) {
    val viewState = viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 30.dp, bottom = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GivenTask(
            givenWord = viewState.value.givenWord,
            givenPronunciation = viewState.value.givenPronunciation
        )

        when (viewState.value.auditionSubState) {
            AuditionSubState.Preparation -> {
                Preparation {
                    viewModel.obtainEvent(AuditionEvent.checkClicked)
                }
            }

            AuditionSubState.Pronunciation -> {
                Pronunciation {
                    viewModel.obtainEvent(AuditionEvent.microphoneClicked)
                }
            }

            AuditionSubState.Success -> {
                Success {
                    onNextClicked()
                }
            }
        }


    }
}