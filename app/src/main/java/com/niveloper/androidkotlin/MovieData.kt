package com.niveloper.androidkotlin

import android.widget.ImageView

data class MovieData(
    val name: String,
    val id: Int,
    val logo: ImageView,
    val aging: Int,
    val storyLine: String,
    val rating: Int,
    val genre: String,
    val reviewsCnt: Int
)