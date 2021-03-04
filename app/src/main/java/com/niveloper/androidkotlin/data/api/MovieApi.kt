package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.data.api.response.ConfigurationResponse
import com.niveloper.androidkotlin.data.api.response.GenresResponse
import com.niveloper.androidkotlin.data.api.response.MovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

private interface MovieApi {
    @GET("configuration")
    suspend fun loadConfiguration(): ConfigurationResponse

    @GET("genre/movie/list")
    suspend fun loadGenres(): GenresResponse

    @GET
    suspend fun loadMovieDetails(
        @Path("movie_id") movie_id: Int
    ): MovieDetailsResponse
}