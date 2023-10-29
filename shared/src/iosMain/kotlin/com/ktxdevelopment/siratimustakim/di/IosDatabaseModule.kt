package com.ktxdevelopment.siratimustakim.di

import com.ktxdevelopment.siratimustakim.data.local.cache.DriverFactory
import org.koin.dsl.module


internal val dbModule = module {
    single { DriverFactory() }
}

fun getDbModule() = dbModule
