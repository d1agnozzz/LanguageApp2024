package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectEvent
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.views.LanguageSelectView
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectScreen(
    onBoardingViewModel: LanguageSelectViewModel,
    onLanguageSelectFinish: () -> Unit,
) {
    val viewState = onBoardingViewModel.viewState.collectAsState()


    with(viewState.value) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.languageSelectTopBarTitle),
                            color = AppColors.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.DeepBlue)
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                LanguageSelectView(
                    this@with,
                    onLanguageSelect = { language ->
                        onBoardingViewModel.obtainEvent(
                            LanguageSelectEvent.LanguageSelected(language)
                        )
                    },
                    onChooseClicked = {
                        onBoardingViewModel.obtainEvent(
                            LanguageSelectEvent.ChooseClicked
                        )
                    }
                )
            }
        }
        LaunchedEffect(key1 = this.isLanguageSelectionFinished) {
            when (isLanguageSelectionFinished) {
                true -> {
                    onLanguageSelectFinish()
                }
                else -> {

                }
            }

        }
    }
}