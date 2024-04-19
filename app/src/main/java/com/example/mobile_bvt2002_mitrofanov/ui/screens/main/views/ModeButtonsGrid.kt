package com.example.mobile_bvt2002_mitrofanov.ui.screens.main.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.ModeButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.models.ModeInfo

@Composable
fun ModeButtonsGrid(
    modes: List<ModeInfo>,
    onModeClicked: (Int) -> Unit

) {
    Text(
        text = stringResource(id = R.string.availableExcercisesLabel),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineSmall
    )
    Spacer(modifier = Modifier.height(9.dp))
    LazyVerticalGrid(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(21.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        for ((i, mode) in modes.withIndex()) {
            item {
                ModeButton(
                    image = mode.image,
                    modeLabel = mode.label,
                    backgroundColor = mode.color,
                    onModeClick = { onModeClicked(i) })
            }
        }

    }

}