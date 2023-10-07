package com.ktxdevelopment.siratimustakim.android.util

import com.ktxdevelopment.siratimustakim.domain.model.util.ApiError

data class DataState<out T>(val data: T? = null, val error: String? = null, val loading: Boolean = false, ) {
    companion object {
        fun <T> success(data: T): DataState<T> { return DataState(data = data,) }
        fun <T> error(message: String, ): DataState<T> { return DataState(error = message) }
        fun <T> loading(): DataState<T> = DataState(loading = true)
    }
}


open class UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>()
    data class Failure(val error: ApiError) : UiState<Nothing>()
    class Loading : UiState<Nothing>()
}