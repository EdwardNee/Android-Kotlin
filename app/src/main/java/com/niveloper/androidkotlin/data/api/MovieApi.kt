package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.datastore.MovieData
import retrofit2.http.GET

@GET()
private interface MovieApi {
    suspend fun loadMovies(): List<MovieData>
}