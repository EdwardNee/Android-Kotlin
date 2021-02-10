package com.niveloper.androidkotlin.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niveloper.androidkotlin.data.JsonLoadRepository
import java.lang.IllegalArgumentException

class MovieListModelFactory(private val repo : JsonLoadRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass){
        MovieListModelFactory::class.java -> MovieListModelFactory(repo)
        else -> throw IllegalArgumentException("$modelClass is not registered")
    } as T
}