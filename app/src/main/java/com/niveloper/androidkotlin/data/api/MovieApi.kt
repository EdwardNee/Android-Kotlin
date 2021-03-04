package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.data.api.response.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
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

    suspend fun loadUpComing(
        @Query("page") page: Int
    ): UpComingResponse
}