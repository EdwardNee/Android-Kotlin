package com.niveloper.androidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies_list)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_main, FragmentMoviesList())
    }
}