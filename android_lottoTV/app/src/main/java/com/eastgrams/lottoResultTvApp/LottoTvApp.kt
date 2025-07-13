package com.eastgrams.lottoResultTvApp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eastgrams.lottoResultTvApp.screen.Screen
import com.eastgrams.lottoResultTvApp.screen.lottoresult.LottoDrawResultScreen
import com.eastgrams.lottoResultTvApp.screen.lottoresult.LottoDrawResultScreenViewModel

@Composable
fun LottoTvApp() {
    LottoTvNavHost(navController = rememberNavController())
}

@Composable
fun LottoTvNavHost( navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.LastLottResult.route,
    ) {
        composable(route = Screen.LastLottResult.route) {
            LottoDrawResultScreen(
                viewModel = hiltViewModel<LottoDrawResultScreenViewModel>(),
            )
        }

        composable(route = Screen.LottResult.route,
            deepLinks = Screen.LottResult.deepLinks!!
        ) {
            LottoDrawResultScreen(
                viewModel = hiltViewModel<LottoDrawResultScreenViewModel>(),
            )
        }


    }
}