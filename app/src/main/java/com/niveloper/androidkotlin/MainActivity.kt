package com.niveloper.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toMoviesList()
    }

    private fun toMoviesList(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_main, FragmentMoviesList())
            .addToBackStack("trans:${FragmentMoviesList::class.java.simpleName}")
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragment = savedInstanceState.

    }
}