package com.niveloper.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //If there is nothing saved that means we do not have any fragments started.
        if (savedInstanceState == null)
            toMoviesList()
    }

    fun onMovieSelected() {
        toMovieDetails()
    }

    fun onMovieDeselected() {
        toMoviesList()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragment = savedInstanceState.

    }
}