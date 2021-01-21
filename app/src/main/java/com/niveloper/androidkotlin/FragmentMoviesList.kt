package com.niveloper.androidkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesList : Fragment() {
    var listener: MoviesListClickListener? = null
    private lateinit var adapter: AdapterMoviesList
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
        view.findViewById<RecyclerView>(R.id.rv_movies).apply {
            //Set a grid: views will be in a 2 columns
            layoutManager = GridLayoutManager(context, 2)
            //Instantiate adapter for recycler
            adapter = AdapterMoviesList()
            setOnClickListener { listener?.onMovieSelected() }
        }
        this.adapter = AdapterMoviesList()
    }

    fun onClickCard(item : MovieData){

    }

//    override fun onStart() {
//        super.onStart()
//        view!!.findViewById<View>(R.id.avengers_framelayout).setOnClickListener {
//            listener?.onMovieSelected()
//        }
//    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }
}

interface MoviesListClickListener {
    fun onMovieSelected()
}