package com.example.mobile_bvt2002_mitrofanov.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.FilledButton
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Composable
fun Profile() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(188.dp)
                .background(AppColors.DeepBlue)
                .padding(horizontal = 24.dp)
                .padding(bottom = 20.dp)
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .size(134.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = "",
                )
                Text(
                    text = "Your profile, " + stringResource(id = R.string.userName),
                    color = AppColors.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            FilledButton(onClick = {}, label = R.string.switchThemeButton)
            Spacer(modifier = Modifier.height(10.dp))
            FilledButton(onClick = {}, label = R.string.changeLanguageButton)
            Spacer(modifier = Modifier.height(10.dp))
            FilledButton(onClick = {}, label = R.string.changeProfilePic)
            Spacer(modifier = Modifier.height(10.dp))
            FilledButton(onClick = {}, label = R.string.logOutButton)

        }

    }
}