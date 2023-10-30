package com.ktxdevelopment.siratimustakim.android.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktxdevelopment.siratimustakim.android.ui.activity.main.MainActivity
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeScreen

@Composable
fun BaseNavigation(activity: MainActivity) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = BaseScreen.Splash.route) {

        composable(route = BaseScreen.Home.route) { navBackStackEntry ->
            HomeScreen(activity)
        }

//        composable(route = BaseScreen.Splash.route) { navBackStackEntry ->
//            SmSplashScreen {
//                navController.navigate(BaseScreen.Home.route)
//            }
//        }
    }
}
