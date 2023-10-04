package com.ktxdevelopment.siratimustakim.domain.model.util

open class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Failure(val error: ApiError) : Resource<Nothing>()
}
