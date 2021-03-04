package com.niveloper.androidkotlin.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GenresResponse(
    @SerialName("genres") val genres: List<GenreResponse>
)