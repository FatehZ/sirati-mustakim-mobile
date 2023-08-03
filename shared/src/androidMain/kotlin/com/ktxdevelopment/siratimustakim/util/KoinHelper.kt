package com.ktxdevelopment.siratimustakim.util
import com.ktxdevelopment.siratimustakim.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}