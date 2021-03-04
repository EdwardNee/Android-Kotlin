package com.niveloper.androidkotlin.data.api.response

import kotlinx.serialization.SerialName

class ConfigurationResponse(
    @SerialName("images") val images: ImageResponse
)