package com.niveloper.androidkotlin.data

import androidx.annotation.DrawableRes

data class ActorData(
    val name: String,
    val id: Int,
    @DrawableRes val logo: Int,
)