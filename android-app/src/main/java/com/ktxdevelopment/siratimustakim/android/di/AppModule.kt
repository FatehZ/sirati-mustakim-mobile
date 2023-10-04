package com.ktxdevelopment.siratimustakim.android.di

import com.ktxdevelopment.siratimustakim.android.ui.activity.main.MainViewModel
import com.ktxdevelopment.siratimustakim.android.ui.screens.post.PostDetailViewModel
import com.ktxdevelopment.siratimustakim.android.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::PostDetailViewModel)
}