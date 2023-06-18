package com.project.assignment.network

import android.os.Build
import androidx.annotation.RequiresApi
import com.project.assignment.model.BaseResponseArrayType
import com.project.assignment.utils.ApiError
import com.project.assignment.utils.AppUtils
import org.json.JSONObject
import retrofit2.Response

abstract class GenericApiRequestArrayType<T : Any> {
    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun <U> apiRequest(


        call: suspend () -> Response<Any>

    ): BaseResponseArrayType<ArrayList<Any>> {
        val dataClass = BaseResponseArrayType<ArrayList<Any>>()

        if (AppUtils.isInternetAvailable()) {
            try {
                dataClass.isInternetOn = true
                val response: Response<Any> = call.invoke()

                if (response.body()!= null) {
                    return if (response.isSuccessful
                    ) {
                        dataClass.arrayData = (response.body() as ArrayList<Any>)
                        dataClass.statusCode=response.code()
                        dataClass.status=response.isSuccessful
                        dataClass.apiError = null

                        dataClass
                    } else {
                        dataClass.apiError = getError(response)
                        dataClass.data = null
                        dataClass
                    }
                } else {
                    dataClass.data = null
                    dataClass.statusCode=response.code()
                    dataClass.apiError = getError(response)
                    return dataClass
                }
            } catch (e: Exception) {

                dataClass.isInternetOn = true
                dataClass.data = null
                dataClass.statusCode=403
                dataClass.apiError = setApiError(true)
                return dataClass
            }

        } else {

            dataClass.isInternetOn = false
            dataClass.data = null
            dataClass.apiError = setApiError(false)
            return dataClass
        }
    }

    private fun setApiError(isInternetOn: Boolean): ApiError {
        val apiError = ApiError()
        if (isInternetOn)
            apiError.message = "Request failed. Please retry"
        else
            apiError.message =
                "It seems like you are not connected with a stable internet connection"
        return apiError

    }

    private fun getError(
        response: Response<Any>
    ): ApiError {
        val error = ApiError()
        if (response.body() != null) {
            error.message = response.message()
            error.statusCode = response.code()
            error.result = response.body()
        } else {
            val jObjError = JSONObject(response.errorBody()!!.string())
            //error = ErrorUtils.parseError(response)!!
            error.statusCode = jObjError.optInt("code")
            error.message = jObjError.optString("message")
                ?: "Unable to process your request. Please try again."
        }
        return error
    }
}