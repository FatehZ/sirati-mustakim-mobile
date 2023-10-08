package com.ktxdevelopment.siratimustakim.android.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ktxdevelopment.siratimustakim.android.R
import com.ktxdevelopment.siratimustakim.android.ui.screens.postlist.PostListScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.postlist.PostListViewModel
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.PostDetailScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.PostDetailViewModel
import com.ktxdevelopment.siratimustakim.android.util.NetType
import com.ktxdevelopment.siratimustakim.android.util.checkNetType


@Composable
fun Navigation(setOnTopBarIconClick: (action: () -> Unit) -> Unit, onUpdateIcon: (drawable: Int) -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.PostList.route) {

        composable(route = Screen.PostList.route) { navBackStackEntry ->
            val viewModel: PostListViewModel = ViewModelProvider(navBackStackEntry)[PostListViewModel::class.java]
            setOnTopBarIconClick {}
            PostListScreen(mState = viewModel.state, onTriggerEvent = viewModel::onTriggerEvent) { postId, netType ->
                navController.navigate("${Screen.PostDetail.route}/$postId?netType=${netType.name}")
            }
        }


        composable(
            route = Screen.PostDetail.route + "/{postId}?netType={netType}",
            arguments = listOf(
                navArgument("postId") { type = NavType.StringType },
                navArgument("netType") { type = NavType.StringType })
        ) { navBackStackEntry ->
//            val factory = ViewModelFactory(LocalContext.current, navBackStackEntry)
//            val viewModel: PostDetailViewModel = viewModel("PostDetailViewModel", factory)

            setOnTopBarIconClick { navController.navigate(Screen.PostList.route) }
            onUpdateIcon(R.drawable.ic_back)

            var postId = ""
            navBackStackEntry.arguments?.getString("postId").let {
                if (!it.isNullOrBlank()) postId = it
                else navController.navigate(Screen.PostList.route)
            }

            val netType: String = navBackStackEntry.arguments?.getString("netType") ?: NetType.REMOTE.name

            val postViewModel: PostDetailViewModel = ViewModelProvider(navBackStackEntry)[PostDetailViewModel::class.java]

            PostDetailScreen(
                mState = postViewModel.state,
                onTriggerEvent = postViewModel::onTriggerEvent,
                postId = postId,
                netType = checkNetType(netType)
//                onNavigateBack =
            )
        }
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


