package com.niveloper.androidkotlin

import androidx.annotation.DrawableRes
import java.io.Serializable

data class MovieData(
    val name: String,
    val id: Int,
    @DrawableRes val logo: Int,
    @DrawableRes val bg: Int,
    val aging: Int,
    val storyLine: String,
    val isLiked: Boolean,
    val rating: Int,
    val genre: String,
    val reviewsCnt: Int,
    val time: Int,
    val cast: List<ActorData>
) : Serializable