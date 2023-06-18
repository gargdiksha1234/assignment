package com.project.assignment.network.api


import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.project.assignment.MainApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

object RetroHelper {
    const val base_url ="https://jsonplaceholder.typicode.com/"
    object ApiManager {

        val apiClient: ApiInterface
            get() {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(base_url)
                    .client(getHttpClient().build())
                    .build()

                return retrofit.create(ApiInterface::class.java)
            }
    }

    /**
     * Method to create [OkHttpClient] builder by adding required headers in the [Request]
     *
     * @return OkHttpClient object
     */
    private fun getHttpClient(): OkHttpClient.Builder {

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(ChuckerInterceptor(MainApplication.instance))
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .writeTimeout(30000, TimeUnit.MILLISECONDS)

    }



}