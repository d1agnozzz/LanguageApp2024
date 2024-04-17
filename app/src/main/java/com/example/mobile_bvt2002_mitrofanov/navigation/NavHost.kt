package com.example.mobile_bvt2002_mitrofanov.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.OnBoardingScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.OnBoardingViewModel

@Composable
fun NavHostInit() {
    val navController = rememberNavController()
    val navGraph = navController.createGraph(startDestination = NavigationTree.OnBoarding.name) {
        composable(NavigationTree.OnBoarding.name) {
            val onBoardingViewModel = hiltViewModel<OnBoardingViewModel>()

            OnBoardingScreen(
                onBoardingViewModel = onBoardingViewModel,
                onOnBoardingFinished = { /*TODO*/ })
        }
    }

    NavHost(navController = navController, graph = navGraph)
}