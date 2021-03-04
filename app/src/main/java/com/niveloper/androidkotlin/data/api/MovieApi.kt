package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.data.api.response.ConfigurationResponse
import retrofit2.http.GET

private interface MovieApi {
    @GET("configuration")
    suspend fun loadConfiguration() : ConfigurationResponse
}