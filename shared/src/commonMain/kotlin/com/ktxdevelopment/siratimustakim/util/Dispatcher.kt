package com.ktxdevelopment.siratimustakim.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

internal expect fun provideDispatcher(): Dispatcher