package com.ktxdevelopment.siratimustakim.domain.model.util

sealed class ApiError(open val message: String) {
    data class NetworkError(override val message: String) : ApiError(message)
    data class ServerError(val code: Int, override val message: String) : ApiError(message)
    // Add more specific error types as needed
}