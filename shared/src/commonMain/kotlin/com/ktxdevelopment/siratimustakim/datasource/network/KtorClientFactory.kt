package com.ktxdevelopment.siratimustakim.datasource.network

expect class KtorClientFactory() {
    fun build(): HttpClient
}