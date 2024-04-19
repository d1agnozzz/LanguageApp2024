package com.example.mobile_bvt2002_mitrofanov.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.mobile_bvt2002_mitrofanov.R
import com.example.mobile_bvt2002_mitrofanov.ui.components.TopBarWithBackButton
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.LanguageSelectScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.languageSelect.LanguageSelectViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.LoginScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.login.LoginViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.MainScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.main.MainViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.AnimalsScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.AnimalsViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.animals.models.AnimalSubstate
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.AuditionScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.AuditionViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.WordsScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.words.WordsViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.OnBoardingScreen
import com.example.mobile_bvt2002_mitrofanov.ui.screens.onBoarding.OnBoardingViewModel
import com.example.mobile_bvt2002_mitrofanov.ui.screens.profile.Profile
import com.example.mobile_bvt2002_mitrofanov.ui.theme.AppColors

@Immutable
data class ScaffoldViewState(
    val showScaffold: Boolean = false,
    @StringRes val topAppBarTitle: Int? = null,
    val topAppBarShowBackButton: Boolean = false,
    val onBackClick: () -> Unit = {},
    val containerColor: Color = AppColors.DeepBlue
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostInit(
    showOnBoarding: Boolean,
) {
    var scaffoldViewState by remember {
        mutableStateOf(ScaffoldViewState())
    }

    Scaffold(
        topBar = if (scaffoldViewState.showScaffold) {
            {

                TopBarWithBackButton(
                    title = {
                        scaffoldViewState.topAppBarTitle?.let {
                            Text(
                                text = stringResource(id = it),
                                color = AppColors.White,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineSmall
                            )

                        }
                    },
                    backgroundColor = scaffoldViewState.containerColor,
                    showBackButton = scaffoldViewState.topAppBarShowBackButton,
                    onBackClick = scaffoldViewState.onBackClick
                )
            }
        } else {
            {}
        }

    ) {
        val navController = rememberNavController()
        val navGraph = navController.createGraph(
            startDestination = when (showOnBoarding) {
                true -> NavigationTree.OnBoarding.name
                else -> NavigationTree.LanguageSelect.name
            }
        ) {
            composable(NavigationTree.OnBoarding.name) {
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = false,
                    )

                }
                val onBoardingViewModel = hiltViewModel<OnBoardingViewModel>()

                OnBoardingScreen(
                    onBoardingViewModel = onBoardingViewModel,
                    onOnBoardingFinished = {
                        navController.navigate(NavigationTree.LanguageSelect.name) {
                            popUpTo(0)
                        }
                    })
            }
            composable(NavigationTree.LanguageSelect.name) {
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = true,
                        topAppBarTitle = R.string.languageSelectTopBarTitle,
                        topAppBarShowBackButton = false
                    )

                }

                val languageSelectViewModel = hiltViewModel<LanguageSelectViewModel>()

                LanguageSelectScreen(onBoardingViewModel = languageSelectViewModel,
                    onLanguageSelectFinish = {
                        navController.navigate(NavigationTree.Login.name) {
//                        popUpTo(0)
                        }
                    }
                )


            }
            composable(NavigationTree.Login.name) {
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = true,
                        topAppBarTitle = R.string.loginHeader,
                        topAppBarShowBackButton = true,
                        onBackClick = { navController.popBackStack() }
                    )

                }

                val loginViewModel = hiltViewModel<LoginViewModel>()

                LoginScreen(loginViewModel = loginViewModel, onLoginSuccess = {
                    navController.navigate(NavigationTree.Main.name) {
                        popUpTo(0)
                    }
                }, onBackClicked = { navController.popBackStack() })
            }
            composable(NavigationTree.Main.name) {
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = false,
                    )


                }
                val mainViewModel = hiltViewModel<MainViewModel>()

                MainScreen(viewModel = mainViewModel, onModeClicked = {
                    navController.navigate(
                        when (it) {
                            0 -> NavigationTree.AnimalQuiz.name
                            1 -> NavigationTree.WordQuiz.name
                            2 -> NavigationTree.Audition.name
                            3 -> NavigationTree.Game.name
                            else -> throw IndexOutOfBoundsException()
                        }
                    )
                }, onUserClicked = {
                    navController.navigate(NavigationTree.Profile.name)
                })
            }
            composable(NavigationTree.Profile.name) {
                Profile()
            }
            composable(NavigationTree.AnimalQuiz.name) {
                val animalsViewModel = hiltViewModel<AnimalsViewModel>()
                val viewState = animalsViewModel.viewState.collectAsState()

                LaunchedEffect(key1 = viewState.value.animalSubstate) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = true,
                        topAppBarTitle = R.string.guessTheAnimalHeader,
                        topAppBarShowBackButton = true,
                        onBackClick = {
                            navController.popBackStack()
                        },
                        containerColor = when (animalsViewModel.viewState.value.animalSubstate) {
                            AnimalSubstate.Quiz -> AppColors.DeepBlue
                            AnimalSubstate.CorrectAnswer -> AppColors.Green
                            AnimalSubstate.WrongAnswer -> AppColors.Red
                        }
                    )

                }

                AnimalsScreen(
                    viewModel = animalsViewModel,
                    onNextClicked = {
                        navController.navigate(NavigationTree.Main.name) {
                            popUpTo(0)
                        }
                    },
                )

            }
            composable(NavigationTree.WordQuiz.name) {
                val wordsViewModel = hiltViewModel<WordsViewModel>()
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = true,
                        topAppBarTitle = R.string.wordsModeHeader,
                        topAppBarShowBackButton = true,
                        onBackClick = {
                            navController.popBackStack()
                        },
                        containerColor = AppColors.DeepBlue
                    )
                }
                WordsScreen(
                    viewModel = wordsViewModel,
                    onNextClicked = { navController.popBackStack() })
            }
            composable(NavigationTree.Audition.name) {
                val auditionViewModel = hiltViewModel<AuditionViewModel>()
                LaunchedEffect(Unit) {
                    scaffoldViewState = scaffoldViewState.copy(
                        showScaffold = true,
                        topAppBarTitle = R.string.AuditionTitle,
                        topAppBarShowBackButton = true,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )

                }
                AuditionScreen(viewModel = auditionViewModel) {
                    navController.popBackStack()

                }
            }
            composable(NavigationTree.Game.name) {
                navController.navigate(NavigationTree.WordQuiz.name)
            }
        }

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            graph = navGraph,
//        enterTransition = {EnterTransition.None}, exitTransition = { ExitTransition.None}
        )

    }
}