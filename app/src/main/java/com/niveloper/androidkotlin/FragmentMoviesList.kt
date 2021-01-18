package com.niveloper.androidkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesList : Fragment() {
    var recycler : RecyclerView? = null
    var listener: MoviesListClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesListClickListener)
            listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rv_movies)
        //Instantiate adapter for recycler
        recycler?.adapter = AdapterMoviesList()
    }

    override fun onStart() {
        super.onStart()
        view!!.findViewById<View>(R.id.avengers_framelayout).setOnClickListener {
            listener?.onMovieSelected()
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }
}

interface MoviesListClickListener {
    fun onMovieSelected()
}