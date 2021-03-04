package com.niveloper.androidkotlin.datastore

data class Movie(
    val id: Int,
    val pgAge: Int,
    val title: String,
    val genres: List<GenreData>,
    val runningTime: Int,
    val reviewCount: Int,
    val isLiked: Boolean,
    val rating: Int,
    val imageUrl: String?
)