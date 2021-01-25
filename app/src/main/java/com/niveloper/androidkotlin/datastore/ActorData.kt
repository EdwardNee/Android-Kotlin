package com.niveloper.androidkotlin.datastore

import java.io.Serializable

data class ActorData(
    val name: String,
    val id: Int,
    val imageUrl: String,
) : Serializable