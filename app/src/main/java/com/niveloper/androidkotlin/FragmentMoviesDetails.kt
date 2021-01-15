package com.niveloper.androidkotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backTv = view.findViewById<TextView>(R.id.back_text).setOnClickListener {
            val frag = FragmentMoviesList()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(this.id, frag, null)
                .addToBackStack(null)
                .commit()
        }
    }
}

interface MovieDetailsBackClickListener{
    fun onMovieDeselected()
}