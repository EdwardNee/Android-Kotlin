package com.niveloper.androidkotlin.datastore

import java.io.Serializable

data class MovieData(
    val name: String,
    val id: Int,
    val logoUrl: String,
    val bgUrl: String,
    val aging: Int,
    val storyLine: String,
    val isLiked: Boolean,
    val rating: Float,
    val genres: List<GenreData>,
    val reviewsCnt: Int,
    val time: Int,
    val cast: List<ActorData>
) : Serializable