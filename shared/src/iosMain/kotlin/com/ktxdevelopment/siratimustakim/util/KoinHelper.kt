package com.ktxdevelopment.siratimustakim.util

import com.ktxdevelopment.siratimustakim.di.getSharedModules

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}
