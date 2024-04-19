package com.example.mobile_bvt2002_mitrofanov.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.modesList
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views.ModeButtonsGrid
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views.TopUsers
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views.UserTopCard

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onModeClicked: (Int) -> Unit,
    onUserClicked: () -> Unit,
) {
    val viewState = viewModel.viewState.collectAsState()

    with(viewState.value) {
        Column(modifier = Modifier.fillMaxSize()) {
            UserTopCard(
                userImage = viewState.value.userImage,
                userName = stringResource(id = viewState.value.userName),
                onUserClicked = {
                    onUserClicked()
                })
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(vertical = 11.dp)
            ) {

                TopUsers(topUsersList = topUsers)
                ModeButtonsGrid(modes = modesList, onModeClicked = { onModeClicked(it) })
            }


        }

    }
}