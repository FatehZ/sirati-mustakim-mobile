package com.ktxdevelopment.siratimustakim.android.nav


sealed class BaseScreen(
    val route: String
){
    object Home: Screen("home")

    object Splash: Screen("splash")
}