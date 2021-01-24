package com.infinitumcode.tinypokedex.data.network

import com.infinitumcode.tinypokedex.data.wrapper.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class NetworkRequestHelper {
    companion object {
        const val NO_INTERNET_ERROR = "Oops!! your internet is lost"
        const val GENERIC_ERROR = "Oops!! something's wrong"
        const val CLIENT_ERROR = "Oops!! we can't resolve your request"
        const val TIMEOUT_ERROR = "Oops!! internet to slow"
        const val SERVER_ERROR = "Oops!! something's wrong in our server, try later"
    }

    protected suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        when (throwable.code()) {
                            in 400..451 -> Result.Error(CLIENT_ERROR)
                            in 500..599 -> Result.Error(SERVER_ERROR)
                            else -> Result.Error(GENERIC_ERROR)
                        }
                    }
                    is ConnectException -> Result.Error(NO_INTERNET_ERROR)
                    is UnknownHostException -> Result.Error(NO_INTERNET_ERROR)
                    is SocketTimeoutException -> Result.Error(TIMEOUT_ERROR)
                    is IOException -> Result.Error(throwable.message)
                    else -> Result.Error(throwable.message)
                }
            }
        }
    }
}
