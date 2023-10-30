package com.ktxdevelopment.siratimustakim.di

import com.ktxdevelopment.siratimustakim.data.local.cache.DriverFactory
import com.ktxdevelopment.siratimustakim.shared.sqldelight.PostDatabase
import org.koin.dsl.module


internal val dbModule = module {
    single { PostDatabase(get()) }
    single { DriverFactory(get()).createDriver() }
}