package com.ktxdevelopment.siratimustakim.android.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ktxdevelopment.siratimustakim.android.ui.activity.home.HomeScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeViewModel
import com.ktxdevelopment.siratimustakim.android.ui.activity.main.MainViewModel
import com.ktxdevelopment.siratimustakim.android.ui.activity.post.PostDetailScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.post.PostDetailViewModel
import com.ktxdevelopment.siratimustakim.android.ui.activity.settings.SettingsScreen
import com.ktxdevelopment.siratimustakim.android.ui.activity.settings.SettingsViewModel


@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) { navBackStackEntry ->
            val viewModel: HomeViewModel = ViewModelProvider(navBackStackEntry)[HomeViewModel::class.java]

            HomeScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent,
                onSelectRecipe = { recipeId ->
                    navController.navigate("${Screen.Home.route}/$recipeId")
                }
            )
        }

    }
        composable(
            route = Screen.PostDetail.route + "/{postId}",
            arguments = listOf(navArgument("postId") { type = NavType.StringType })
        ) { navBackStackEntry ->
//            val factory = ViewModelFactory(LocalContext.current, navBackStackEntry)
//            val viewModel: PostDetailViewModel = viewModel("PostDetailViewModel", factory)

            val postViewModel: PostDetailViewModel = ViewModelProvider(navBackStackEntry)[PostDetailViewModel::class.java]
            val mainViewModel: MainViewModel = ViewModelProvider(navBackStackEntry)[MainViewModel::class.java]

            PostDetailScreen(
                state = postViewModel.state,
                onTriggerEvent = postViewModel::onTriggerEvent
            )
        }


        composable(
            route = Screen.Settings.route,
//            arguments = listOf(navArgument("postId") { type = NavType.StringType })
        ) { navBackStackEntry ->
//            val factory = ViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: SettingsViewModel = ViewModelProvider(navBackStackEntry)[SettingsViewModel::class.java]

            SettingsScreen(
                state = viewModel.state,
                onTriggerEvent = viewModel::onTriggerEvent
            )
        }
    }
}