package com.example.myapplication.data.network

import com.example.myapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    private val HEADER_AUTHORIZATION = "x-api-key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader(HEADER_AUTHORIZATION, BuildConfig.API_KEY)
        return chain.proceed(builder.build())
    }
}