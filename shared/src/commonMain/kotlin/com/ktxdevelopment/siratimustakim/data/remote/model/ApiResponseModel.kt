package com.ktxdevelopment.siratimustakim.data.remote.model


data class ApiResponseModel<T>(
    val data: T, //todo check nullable or not
    val error: RestError
)

data class RestError(val title: String, val message: String)
