package com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

val topUsers = listOf(
    TopUserInfo(
        userImage = R.drawable.artist,
        userName = "Vincent van Gogh",
        pointsCount = 12
    ),
    TopUserInfo(
        userImage = R.drawable.scientist,
        userName = "Albert Einstein",
        pointsCount = 10,
    ),
    TopUserInfo(
        userImage = R.drawable.vampire,
        userName = "Dracula",
        pointsCount = 8
    )

)

val modesList = listOf(
    ModeInfo(
        image = R.drawable.bear,
        label = R.string.guessTheAnimalModeLabel,
        color = AppColors.Blue
    ),
    ModeInfo(
        image = R.drawable.pencil,
        label = R.string.wordPracticeModeLabel,
        color = AppColors.Red,
    ),
    ModeInfo(
        image = R.drawable.speaker,
        label = R.string.auditionModeLabel,
        color = AppColors.Orange
    ),
    ModeInfo(
        image = R.drawable.joystick,
        label = R.string.gameModeLabel,
        color = AppColors.Green,
    )
)

data class ModeInfo(
    @DrawableRes val image: Int,
    @StringRes val label: Int,
    val color: Color,
)

data class MainViewState(
    @DrawableRes val userImage: Int,
    @StringRes val userName: Int,
    val topUsers: List<TopUserInfo>,

    )

data class TopUserInfo(
    @DrawableRes val userImage: Int,
    val userName: String,
    val pointsCount: Int,
)
