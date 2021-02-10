package com.niveloper.androidkotlin.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niveloper.androidkotlin.data.JsonLoadRepository
import com.niveloper.androidkotlin.datastore.MovieData
import kotlinx.coroutines.launch

class MovieListViewModel(private val repo: JsonLoadRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<MovieData?>>()
    val movies : LiveData<List<MovieData?>> get() = _movies

    init {
        loadMovies()
    }

    private fun loadMovies(){
        viewModelScope.launch {
            _movies.value = repo.loadMovies()
        }
    }
}