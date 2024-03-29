package com.niveloper.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niveloper.androidkotlin.data.JsonLoad
import com.niveloper.androidkotlin.data.JsonLoadRepository
import com.niveloper.androidkotlin.datastore.MovieData
import com.niveloper.androidkotlin.moviedetails.FragmentMoviesDetails
import com.niveloper.androidkotlin.moviedetails.MovieDetailsBackClickListener
import com.niveloper.androidkotlin.movielist.FragmentMoviesList
import com.niveloper.androidkotlin.movielist.MoviesListClickListener

class MainActivity : AppCompatActivity(), MoviesListClickListener, MovieDetailsBackClickListener,
    JsonLoadRepositoryInterface {
    private val jsonLoadRepo = JsonLoad(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //If there is nothing saved that means we do not have any fragments started.
        if (savedInstanceState == null)
            toMoviesList()
    }

    override fun onMovieSelected(movie: MovieData) {
        toMovieDetails(movie)
    }

    override fun onMovieDeselected() {
        toBack()
    }

    /**
     * Function replaces previous fragment to fragment movies list.
     */
    private fun toMoviesList() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container_main,
                FragmentMoviesList(),
                FragmentMoviesList::class.java.simpleName
            )
            .addToBackStack("trans:${FragmentMoviesList::class.java.simpleName}")
            .commit()
    }

    /**
     * Function adds a fragment movie details to fragment_container
     */
    private fun toMovieDetails(movie: MovieData) {
        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.fragment_container_main,
                FragmentMoviesDetails.newInstance(movie.id),
                FragmentMoviesDetails::class.java.simpleName
            )
                .addToBackStack("trans:${FragmentMoviesDetails::class.java.simpleName}")
                .commit()
        }
    }

    /**
     * Function goes back to last fragment.
     */
    private fun toBack() {
        supportFragmentManager.popBackStack()
    }

    override fun provideJsonLoadRepository(): JsonLoadRepository = jsonLoadRepo
}