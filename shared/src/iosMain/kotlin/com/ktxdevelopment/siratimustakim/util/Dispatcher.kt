package com.ktxdevelopment.siratimustakim.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.newFixedThreadPoolContext

internal class AndroidDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() = newFixedThreadPoolContext(nThreads = 200, name = "IO")
}

internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()