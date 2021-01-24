package com.infinitumcode.tinypokedex.data.wrapper

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String? = null) : Result<Nothing>()
}
