package com.niveloper.androidkotlin

import com.niveloper.androidkotlin.data.JsonLoadRepository

interface JsonLoadRepositoryInterface {
    fun provideJsonLoadRepository() : JsonLoadRepository
}