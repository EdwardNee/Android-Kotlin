package com.niveloper.androidkotlin

import android.widget.ImageView

class DataStorage {
    fun getListOfMovies() : Array<MovieData> =
        arrayOf(
            MovieData(
                "Avengers: End Game", 1, R.drawable.orig, 13,
            )
        )
}