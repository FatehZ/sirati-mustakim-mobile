package com.ktxdevelopment.siratimustakim.android.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeViewModel
import com.ktxdevelopment.siratimustakim.android.ui.screens.post.PostDetailScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.post.PostDetailViewModel


@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) { navBackStackEntry ->
            val viewModel: HomeViewModel =
                ViewModelProvider(navBackStackEntry)[HomeViewModel::class.java]

            HomeScreen(
                state = viewModel.state.collectAsState().value,
                onTriggerEvent = viewModel::onTriggerEvent
            ) { postId ->
                navController.navigate("${Screen.PostDetail.route}/$postId")
            }
        }


        composable(
            route = Screen.PostDetail.route + "/{netType}/{postId}",
            arguments = listOf(
                navArgument("postId") { type = NavType.StringType },
                navArgument("netType") { type = NavType.StringType })
        ) { navBackStackEntry ->
//            val factory = ViewModelFactory(LocalContext.current, navBackStackEntry)
//            val viewModel: PostDetailViewModel = viewModel("PostDetailViewModel", factory)

            var postId: String = ""
            navBackStackEntry.arguments?.getString("postId").let {
                if (!it.isNullOrBlank()) postId = it
                else navController.navigate(Screen.Home.route)
            }

            val netType: String = navBackStackEntry.arguments?.getString("netType") ?: NetType.REMOTE.name

            val postViewModel: PostDetailViewModel = ViewModelProvider(navBackStackEntry)[PostDetailViewModel::class.java]

            PostDetailScreen(
                state = postViewModel.state.collectAsState().value,
                onTriggerEvent = postViewModel::onTriggerEvent,
                postId = postId,
                netType = checkNetType(netType)
//                onNavigateBack =
            )
        }
    }
}

fun checkNetType(str: String): NetType {
    return if (str == NetType.LOCAL.name) {
        NetType.LOCAL
    }else {
        NetType.REMOTE
    }
}


//        composable(
//            route = Screen.Settings.route,
////            arguments = listOf(navArgument("postId") { type = NavType.StringType })
//        ) { navBackStackEntry ->
////            val factory = ViewModelFactory(LocalContext.current, navBackStackEntry)
//            val viewModel: SettingsViewModel = ViewModelProvider(navBackStackEntry)[SettingsViewModel::class.java]
//
//            SettingsScreen(
//                state = viewModel.state,
//                onTriggerEvent = viewModel::onTriggerEvent
//            )
//        }


enum class NetType{
    LOCAL, REMOTE;
}

