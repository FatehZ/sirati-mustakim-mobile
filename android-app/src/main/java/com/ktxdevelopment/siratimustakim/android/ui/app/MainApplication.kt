package com.ktxdevelopment.siratimustakim.android.ui.app

import android.app.Application
import com.ktxdevelopment.siratimustakim.android.di.appModule
import com.ktxdevelopment.siratimustakim.util.getAndroidDbModules
import com.ktxdevelopment.siratimustakim.util.getAndroidSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule + getAndroidDbModules() + getAndroidSharedModules())
        }
    }
}