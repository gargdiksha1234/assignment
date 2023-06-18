package com.project.assignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.project.assignment.utils.ApiError

open class BaseResponseArrayType<T> {

    var apiError: ApiError? = null
    var isInternetOn = true
    var status: Boolean = false

    @SerializedName("type")
    @Expose
    var type: String = ""

    @SerializedName("code")
    @Expose
    var statusCode: Int = 0
    @SerializedName("total_count")
    @Expose
    var totalCount: Int = 0

    @SerializedName("message")
    @Expose
    var message: String = ""

    @SerializedName("results")
    @Expose
    var data: T? = null

    @SerializedName("listing_id")
    @Expose
    var arrayData: T? = null
}