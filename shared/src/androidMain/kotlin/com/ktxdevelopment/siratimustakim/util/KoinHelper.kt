package com.ktxdevelopment.siratimustakim.util
import com.ktxdevelopment.siratimustakim.di.dbModule
import com.ktxdevelopment.siratimustakim.di.getSharedModules

fun getAndroidSharedModules() = getSharedModules()
fun getAndroidDbModules() = dbModule