package com.ktxdevelopment.siratimustakim.android.ui.app

import android.app.Application
import com.ktxdevelopment.siratimustakim.util.initKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}