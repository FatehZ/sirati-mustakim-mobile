package com.ktxdevelopment.siratimustakim.android.ui.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.ktxdevelopment.siratimustakim.android.nav.Navigation
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMAppMainTheme()
        }
    }
}

@Composable
fun SMAppMainTheme() {

    Surface(color = MaterialTheme.colors.background) {
        HomeScreen()
    }
}