package com.eastgrams.lottoResultTvApp.screen

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

sealed class Screen (
    var route: String,
    var navArguments: List<NamedNavArgument> = emptyList(),
    var deepLinks: List<NavDeepLink>? = null
) {
    data object LastLottResult : Screen(
        route = "lottoResult"
    )

    data object LottResult : Screen(
        route = "lottoResult/{drwNo}",
        navArguments = listOf( navArgument("drwNo"){
            type = NavType.IntType
        }),
        deepLinks = listOf(
            navDeepLink { uriPattern = "lottotv://lottotv.app/{drwNo}" }
        )
    ){
        fun createRoute(drwNo: Int) = "lottoResult/${drwNo}"
    }

}
