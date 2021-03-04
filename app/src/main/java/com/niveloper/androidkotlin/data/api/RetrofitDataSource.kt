package com.niveloper.androidkotlin.data.api

import com.niveloper.androidkotlin.data.DataSourceInterface
import com.niveloper.androidkotlin.datastore.Movie
import com.niveloper.androidkotlin.datastore.MovieData

class RetrofitDataSource(val api: MovieApi) : DataSourceInterface {
    override suspend fun loadMovies(): List<MovieData> {
        api.loadConfiguration();
        val genres = api.loadGenres().genres
        return api.loadUpComing(page = 1).results.map { movie ->
            Movie(
                id = movie.id,
                title = movie.title,
                imageUrl = buildUrl(movie)
            )
        }
    }

    override suspend fun loadMovie(movieId: Int): Movie {
        api.loadConfiguration();
    }

    private fun buildUrl(url: String?, size: String?, path: String?): String? {
        return if (url == null || path == null) {
            null
        } else {
            url.plus(size.takeUnless { it.isNullOrEmpty() } ?: "original")
                .plus(path)
        }
    }
}