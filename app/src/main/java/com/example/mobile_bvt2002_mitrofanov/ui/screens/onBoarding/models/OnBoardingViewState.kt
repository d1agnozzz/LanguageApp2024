package com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.models

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Paragraph
import com.example.mobile_bvt2002_mitrofanov.R

data class OnBoardingStage(
    val stageNum: Int = 0,
)

const val ON_BOARDING_PAGES = 3

data class OnBoardingViewState(
    val onBoardingStage: OnBoardingStage,
    val imageRes: Int,
    val title: String,
    val description: String,
    val buttonText: String,
)

val onBoardPagesList = listOf(
    OnBoardingViewState(
        onBoardingStage = OnBoardingStage(0),
        imageRes = R.drawable.illustration_1,
        title = "Confidence in your words",
        description = "With conversation-based learning, you'll be talking from lesson one",
        buttonText = "Next"
    ),
    OnBoardingViewState(
        onBoardingStage = OnBoardingStage(1),
        imageRes = R.drawable.illustration_2,
        title = "Take your time to learn",
        description = "Develop a habit of learning and make it a part of your daily routine",
        buttonText = "More"
    ),
    OnBoardingViewState(
        onBoardingStage = OnBoardingStage(2),
        imageRes = R.drawable.illustration_3,
        title = "The lessons you need to learn",
        description = "Using a variety of learning styles to learn and retain",
        buttonText = "Choose a language"
    )
)