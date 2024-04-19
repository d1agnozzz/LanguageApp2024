package com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.TopUserCard
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.TopUserInfo


@Composable
fun TopUsers(
    topUsersList: List<TopUserInfo>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.topUsersLabel),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            TopUserCard(
                userImage = topUsersList[0].userImage,
                userName = topUsersList[0].userName,
                userPointsCount = topUsersList[0].pointsCount
            )
            TopUserCard(
                userImage = topUsersList[1].userImage,
                userName = topUsersList[1].userName,
                userPointsCount = topUsersList[0].pointsCount
            )
            TopUserCard(
                userImage = topUsersList[2].userImage,
                userName = topUsersList[2].userName,
                userPointsCount = topUsersList[1].pointsCount
            )
        }

    }
}