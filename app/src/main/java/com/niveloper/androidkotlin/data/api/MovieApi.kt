package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.data.api.response.ConfigurationResponse
import com.niveloper.androidkotlin.data.api.response.GenresResponse
import com.niveloper.androidkotlin.data.api.response.MovieCastResponse
import com.niveloper.androidkotlin.data.api.response.MovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

private interface MovieApi {
    @GET("configuration")
    suspend fun loadConfiguration(): ConfigurationResponse

    @GET("genre/movie/list")
    suspend fun loadGenres(): GenresResponse

    @GET("movie/{movie_id}")
    suspend fun loadMovieDetails(
        @Path("movie_id") movieId: Int
    ): MovieDetailsResponse

    @GET("movie/{movie_id}/credits")
    suspend fun loadCast(
        @Path("movie_id") movieId: Int
    ): MovieCastResponse
}