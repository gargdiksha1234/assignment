package com.project.assignment.network.api
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("users")
    suspend fun userList():Response<Any>


}