package com.niveloper.androidkotlin.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.niveloper.androidkotlin.data.JsonLoadRepository
import java.lang.IllegalArgumentException

class MovieDetailsModelFactory(private val repo: JsonLoadRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieDetailsViewModel::class.java -> MovieDetailsViewModel(repo)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}