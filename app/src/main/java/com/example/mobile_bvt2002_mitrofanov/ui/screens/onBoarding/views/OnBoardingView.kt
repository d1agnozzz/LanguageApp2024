package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.OnBoardingProgress
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingStage
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.OnBoardingViewState
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models.onBoardPagesList
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun OnBoardingView(
    viewState: OnBoardingStage,
    onContinueClicked: () -> Unit,
    onSkipClicked: () -> Unit,
) {
    with(viewState) {

        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(24.dp)
                .fillMaxSize()
        ) {
            AnimatedContent(targetState = viewState.stageNum, transitionSpec = {
                ContentTransform(targetContentEnter = fadeIn(), initialContentExit = fadeOut())
            }) { targetCount ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(onBoardPagesList[targetCount].imageRes),
                        contentDescription = null,
                        modifier = Modifier.size(240.dp, 257.dp)
                    )
                    OnBoardingProgress(
                        stage = viewState.stageNum,
                        modifier = Modifier.width(50.dp).padding(vertical = 48.dp)
                    )
                    Column {
                        Text(
                            text = onBoardPagesList[targetCount].title,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .width(288.dp)
                                .padding(4.dp),
                            textAlign = TextAlign.Center

                        )

                        Text(
                            text = onBoardPagesList[targetCount].description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                            modifier = Modifier
                                .width(256.dp)
                                .padding(4.dp),
                            textAlign = TextAlign.Center

                        )
                    }

                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.fillMaxWidth())
                Column {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        onClick = onContinueClicked
                    ) {
                        Text(
                            text = onBoardPagesList[viewState.stageNum].buttonText,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        onClick = onSkipClicked
                    ) {
                        Text(
                            text = "Skip onboarding",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
        }
    }
}