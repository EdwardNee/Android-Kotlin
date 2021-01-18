package com.niveloper.androidkotlin

import androidx.annotation.DrawableRes

data class MovieData(
    val name: String,
    val id: Int,
    @DrawableRes val logo: Int,
    val aging: Int,
    val storyLine: String,
    val rating: Int,
    val genre: String,
    val reviewsCnt: Int
)