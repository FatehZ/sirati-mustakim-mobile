package com.ktxdevelopment.siratimustakim

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform