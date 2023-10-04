package com.ktxdevelopment.siratimustakim.android.nav

sealed class Screen(
    val route: String
){
    object Home: Screen("home")

    object PostDetail: Screen("postdetail")

    object Settings: Screen("settings")

    object Feedback: Screen("feedback")

    object SignIn: Screen("signin")

    object SignUp: Screen("signup")

    object PasswordForgot: Screen("passforgot")

    object Messenger: Screen("messenger")

    object SavedPosts: Screen("savedposts")
}