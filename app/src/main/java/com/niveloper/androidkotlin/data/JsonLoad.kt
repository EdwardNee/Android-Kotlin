package com.niveloper.androidkotlin.data

import android.content.Context
import com.niveloper.androidkotlin.datastore.ActorData
import com.niveloper.androidkotlin.datastore.GenreData
import com.niveloper.androidkotlin.datastore.MovieData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface JsonLoadRepository {
    suspend fun loadMovies(): List<MovieData>
    suspend fun loadMovie(movieId: Int): MovieData
}

internal class JsonLoad(private val context: Context) : JsonLoadRepository {
    private val jsonFormat = Json { ignoreUnknownKeys = true }

    private var movies: List<MovieData>? = null

//    @Suppress("unused")
//    suspend fun loadMovies(context: Context): List<MovieData> = withContext(Dispatchers.IO) {
//        val genresMap = loadGenres(context)
//        val actorsMap = loadActors(context)
//
//        val data = readAssetFileToString(context, "data.json")
//        parseMovies(data, genresMap, actorsMap)
//    }

    private suspend fun loadMoviesFromJson(): List<MovieData> = withContext(Dispatchers.IO) {
        val genresMap = loadGenres(context)
        val actorsMap = loadActors(context)

        val data = readAssetFileToString(context, "data.json")
        parseMovies(data, genresMap, actorsMap)
    }


    override suspend fun loadMovies(): List<MovieData> = withContext(Dispatchers.IO) {
        val cachedMovies = movies
        if (cachedMovies != null) {
            cachedMovies
        } else {
            val moviesFromJson = loadMoviesFromJson()
            movies = moviesFromJson
            moviesFromJson
        }
    }

    override suspend fun loadMovie(movieId: Int): MovieData {
        val cachedMovies = movies ?: loadMovies()
        return cachedMovies.find { it.id == movieId }!!
    }


    private suspend fun loadGenres(context: Context): List<GenreData> =
        withContext(Dispatchers.IO) {
            val data = readAssetFileToString(context, "genres.json")
            parseGenres(data)
        }

    private fun readAssetFileToString(context: Context, fileName: String): String {
        val stream = context.assets.open(fileName)
        return stream.bufferedReader().readText()
    }

    internal fun parseGenres(jsonString: String): List<GenreData> {
        val jsonGenres = jsonFormat.decodeFromString<List<JsonGenre>>(jsonString)
        return jsonGenres.map { jsonGenre -> GenreData(id = jsonGenre.id, name = jsonGenre.name) }
    }

    private suspend fun loadActors(context: Context): List<ActorData> =
        withContext(Dispatchers.IO) {
            val data = readAssetFileToString(context, "people.json")
            parseActors(data)
        }

    internal fun parseActors(jsonString: String): List<ActorData> {
        val jsonActors = jsonFormat.decodeFromString<List<JsonActor>>(jsonString)
        return jsonActors.map { jsonActor ->
            ActorData(
                id = jsonActor.id,
                name = jsonActor.name,
                imageUrl = jsonActor.profilePicture
            )
        }
    }

    internal fun parseMovies(
        jsonString: String,
        genreData: List<GenreData>,
        actors: List<ActorData>
    ): List<MovieData> {
        val genresMap = genreData.associateBy(GenreData::id)
        val actorsMap = actors.associateBy(ActorData::id)

        val jsonMovies = jsonFormat.decodeFromString<List<JsonMovie>>(jsonString)

        return jsonMovies.map { jsonMovie ->
            @Suppress("unused")
            MovieData(
                id = jsonMovie.id,
                title = jsonMovie.title,
                storyLine = jsonMovie.overview,
                logoUrl = jsonMovie.posterPicture,
                bgUrl = jsonMovie.backdropPicture,
                rating = (jsonMovie.ratings / 2).toInt().toFloat(),
                reviewsCnt = jsonMovie.votesCount,
                aging = if (jsonMovie.adult) 16 else 13,
                time = jsonMovie.runtime,
                genres = jsonMovie.genreIds.map { id ->
                    genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                },
                cast = jsonMovie.actors.map { id ->
                    actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                },
                isLiked = false
            )
        }
    }

    private fun <T : Any> T?.orThrow(createThrowable: () -> Throwable): T {
        return this ?: throw createThrowable()
    }

}