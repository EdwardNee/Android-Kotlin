package com.niveloper.androidkotlin

import androidx.annotation.DrawableRes

data class ActorData(
    val name: String,
    val id: Int,
    @DrawableRes val logo: Int,
)