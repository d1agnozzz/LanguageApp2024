package com.example.mobile_bvt2002_mitrofanov.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun OnBoardingProgress(
    modifier: Modifier = Modifier,
    stage: Int,
) {
    val isDark = isSystemInDarkTheme()

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(3) {
            Canvas(modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(8.dp)) {
                drawCircle(
                    color = when {
                        it == stage  -> AppColors.Orange
                        else -> when (isDark) {
                            true -> AppColors.White30
                            else -> AppColors.Dark20
                        }
                    }, radius = 4.dp.toPx()
                )
            }

        }

    }

}