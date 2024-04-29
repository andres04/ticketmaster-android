package com.ticketmaster.app.data.dataSources.response

sealed class DataResponse<out T> {
    data class OnSuccess<out T>(val data: T) : DataResponse<T>()
    data class OnError<out T>(val error: DataError) : DataResponse<T>()
}

open class DataError (
    val code: Int? = 0,
    val message: String? = null,
    val cause: Throwable? = null
)

open class ErrorThrowable(
    private val code: Int? = 0,
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(message, cause) {
    fun toError(): DataError = DataError(code, message, cause)
}

class NetworkError(code: Int? = 0, message: String? = null, cause: Throwable? = null):
    DataError(code, message ?: "Internet connection error", cause)

class HttpError(code: Int? = 0, message: String? = null, cause: Throwable? = null):
    DataError(code, message, cause)

class UnknownError(code: Int? = 0, message: String? = null, cause: Throwable? = null):
    DataError(code, message ?: "Unknown error", cause)

class DataNotFoundError(code: Int? = 0, message: String? = null, cause: Throwable? = null):
    DataError(code, message ?: "Data not found", cause)

class TimeoutError(code: Int? = 0, message: String? = null, cause: Throwable? = null):
    DataError(code, message ?: "Timeout", cause)
