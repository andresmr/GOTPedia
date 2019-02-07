package com.omniumlab.gotpedia.domain.entity

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val errorMessage: HttpError) : Result<Nothing>()
}