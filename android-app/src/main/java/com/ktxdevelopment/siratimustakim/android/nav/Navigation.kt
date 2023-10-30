package com.ktxdevelopment.siratimustakim.android.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ktxdevelopment.siratimustakim.android.R
import com.ktxdevelopment.siratimustakim.android.ui.activity.main.MainActivity
import com.ktxdevelopment.siratimustakim.android.ui.screens.postlist.PostListScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.postlist.PostListViewModel
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.PostDetailScreen
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.PostDetailViewModel
import com.ktxdevelopment.siratimustakim.android.util.NetType
import com.ktxdevelopment.siratimustakim.android.util.checkNetType
import org.koin.androidx.viewmodel.ext.android.viewModel


@Composable
fun Navigation(mainActivity: MainActivity, setOnTopBarIconClick: (action: () -> Unit) -> Unit, onUpdateIcon: (drawable: Int) -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RemoteAllPostList.route) {

        composable(route = Screen.RemoteAllPostList.route) { navBackStackEntry ->

            val viewModel: PostListViewModel by mainActivity.viewModel()

            setOnTopBarIconClick {}
            onUpdateIcon(R.mipmap.ic_launcher_round)

            PostListScreen(mState = viewModel.state, onTriggerEvent = viewModel::onTriggerEvent) { postId ->
                navController.navigate("${Screen.PostDetail.route}/$postId?netType=${NetType.REMOTE.name}")
            }
        }


        composable(
            route = Screen.PostDetail.route + "/{postId}?netType={netType}",
            arguments = listOf(
                navArgument("postId") { type = NavType.StringType },
                navArgument("netType") { type = NavType.StringType })
        ) { navBackStackEntry ->

            setOnTopBarIconClick { navController.navigate(Screen.RemoteAllPostList.route) }
            onUpdateIcon(R.drawable.ic_back)

            var postId = ""
            navBackStackEntry.arguments?.getString("postId").let {
                if (!it.isNullOrBlank()) postId = it
                else navController.navigate(Screen.RemoteAllPostList.route)
            }

            val netType: String = navBackStackEntry.arguments?.getString("netType") ?: NetType.REMOTE.name

            val postViewModel: PostDetailViewModel by mainActivity.viewModel()

            PostDetailScreen(
                mState = postViewModel.state,
                onTriggerEvent = postViewModel::onTriggerEvent,
                postId = postId,
                netType = checkNetType(netType)
            ) {
                navController.navigate(Screen.RemoteAllPostList.route) }
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


