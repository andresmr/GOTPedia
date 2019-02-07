package com.omniumlab.gotpedia.domain.entity

enum class HttpError {
    REDIRECTION,
    CLIENT,
    SERVER,
    UNKNOWN
}

fun Int.convertToHttpError() = when (this) {
    in 300..399 -> HttpError.REDIRECTION
    in 400..499 -> HttpError.CLIENT
    in 500..599 -> HttpError.SERVER
    else -> HttpError.UNKNOWN
}
