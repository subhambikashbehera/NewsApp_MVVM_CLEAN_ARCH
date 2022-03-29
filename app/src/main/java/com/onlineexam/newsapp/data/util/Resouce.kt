package com.onlineexam.newsapp.data.util

sealed class Resouce<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resouce<T>(data)
    class Loading<T>(data: T? = null) : Resouce<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resouce<T>(data, message)
}
