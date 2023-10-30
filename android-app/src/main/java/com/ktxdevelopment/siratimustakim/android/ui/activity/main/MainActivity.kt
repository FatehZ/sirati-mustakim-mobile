package com.ktxdevelopment.siratimustakim.android.ui.activity.main

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.ktxdevelopment.siratimustakim.android.nav.BaseNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                 .detectDiskReads()
                 .detectDiskWrites()
                 .detectNetwork()   // or .detectAll() for all detectable problems
                 .penaltyLog()
                 .build());
        setContent {
            SMAppMainTheme(this@MainActivity)
        }
    }
}

@Composable
fun SMAppMainTheme(mainActivity: MainActivity) {

        Surface(color = MaterialTheme.colors.background) {
            BaseNavigation(mainActivity)
    }
}
