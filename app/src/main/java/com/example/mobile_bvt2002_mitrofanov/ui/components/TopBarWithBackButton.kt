package com.example.mobile_bvt2002_mitrofanov.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackButton(
    title: @Composable () -> Unit,
    backgroundColor: Color = AppColors.DeepBlue,
    showBackButton: Boolean = true,
    onBackClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = title,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        ),
        navigationIcon = {
            if (showBackButton) {
                Icon(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .clickable {
                            onBackClick()
                        },
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = stringResource(
                        id = R.string.topBarBackButton
                    ),
                    tint = AppColors.White
                )

            }

        }
    )
}