package com.niveloper.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), MoviesListClickListener, MovieDetailsBackClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //If there is nothing saved that means we do not have any fragments started.
        if (savedInstanceState == null)
            toMoviesList()
    }

    override fun onMovieSelected() {
        toMovieDetails()
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
    private fun toMovieDetails() {
        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.fragment_container_main,
                FragmentMoviesDetails(),
                FragmentMoviesDetails::class.java.simpleName
            )
                .addToBackStack("trans:${FragmentMoviesDetails::class.java.simpleName}")
                .commit()
        }
    }

    /**
     * Function goes back to last fragment.
     */
    private fun toBack(){
        supportFragmentManager.popBackStack()
    }
}