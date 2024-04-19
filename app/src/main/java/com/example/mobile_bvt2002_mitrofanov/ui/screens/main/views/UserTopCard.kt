package com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun UserTopCard(
    @DrawableRes userImage: Int,
    userName: String,
    onUserClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(AppColors.DeepBlue)
            .clickable { onUserClicked() }
    ) {
        Column(
            modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 24.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .clip(CircleShape)
                    .size(54.dp),
                painter = painterResource(id = userImage),
                contentDescription = "your profile picture",
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = stringResource(id = R.string.userGreeting) + userName,
                color = AppColors.White,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                modifier = Modifier.padding(bottom = 11.dp),
                text = stringResource(id = R.string.inspirationalQuote),
                color = AppColors.White.copy(alpha = 0.6f),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}