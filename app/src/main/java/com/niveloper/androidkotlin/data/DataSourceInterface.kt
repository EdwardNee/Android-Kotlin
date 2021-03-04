package com.niveloper.androidkotlin.data

import com.niveloper.androidkotlin.datastore.Movie
import com.niveloper.androidkotlin.datastore.MovieData

interface DataSourceInterface {
    suspend fun loadMovies(): List<MovieData>
    suspend fun loadMovie(movieId: Int): Movie
}