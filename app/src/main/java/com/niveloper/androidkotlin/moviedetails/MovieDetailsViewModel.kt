package com.niveloper.androidkotlin.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niveloper.androidkotlin.data.JsonLoadRepository
import com.niveloper.androidkotlin.datastore.MovieData
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repo: JsonLoadRepository) : ViewModel() {
    private val _movie = MutableLiveData<MovieData?>()
    val movie: LiveData<MovieData?> get() = _movie

    fun loadMovies(movieId: Int) {
        viewModelScope.launch {
            _movie.value = repo.loadMovie(movieId)
        }
    }
}