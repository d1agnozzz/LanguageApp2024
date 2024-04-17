package com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.Language
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.models.LanguageSelectViewState
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun LanguageSelectView(
    viewState: LanguageSelectViewState,
    onLanguageSelect: (language: Language) -> Unit,
    onChooseClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp)
            .padding(top = 12.dp, bottom = 24.dp)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "What is your Mother Language?",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
            LazyColumn {
                for (language in Language.entries) {
                    item {
                        FilledButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                                .height(67.dp),
                            onClick = {onLanguageSelect(language)},
                            colors = ButtonDefaults.buttonColors(containerColor = when (language == viewState.selectedLanguage) {
                                true -> AppColors.Orange
                                else -> AppColors.LightCream
                            })
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = language.name,
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = AppColors.Dark
                                )
                            }
                        }

                    }

                }
            }

            Spacer(modifier = Modifier.weight(1f))

            FilledButton(onClick = onChooseClicked) {
                Text(text = "Choose", style = MaterialTheme.typography.headlineMedium)

            }

        }

    }
}