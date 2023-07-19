package com.ktxdevelopment.siratimustakim.android.di

import com.ktxdevelopment.siratimustakim.android.ui.activity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
}