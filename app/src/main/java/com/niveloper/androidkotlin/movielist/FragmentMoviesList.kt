package com.niveloper.androidkotlin.movielist

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niveloper.androidkotlin.JsonLoadRepositoryInterface
import com.niveloper.androidkotlin.R
import com.niveloper.androidkotlin.data.JsonLoadRepository
import com.niveloper.androidkotlin.datastore.MovieData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesList : Fragment() {
    var listener: MoviesListClickListener? = null
    var movies: List<MovieData>? = null

    //Init viewModel
    private val viewModel: MovieListViewModel by viewModels {
        MovieListModelFactory((requireActivity() as JsonLoadRepositoryInterface).provideJsonLoadRepository())
    }

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
            val adapter = AdapterMoviesList { movieData -> listener?.onMovieSelected(movieData) }
            //addItemDecoration(CharacterItemDecoration(50))
            this.adapter = adapter

            //adapter.submitList(DataStorage.getListOfMovies())
            loadDataToAdapter(adapter)
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    /**
     * Загружает вне главного потока данные о фильме в адаптер.
     */
    private fun loadDataToAdapter(adapter: AdapterMoviesList) {
        lifecycleScope.launch {
            viewModel.movies.observe(
                viewLifecycleOwner,
                { movieList -> adapter.submitList(movieList) })
            /* commented for MVVM
            val repos =
                (requireActivity() as JsonLoadRepositoryInterface).provideJsonLoadRepository()
            val moviesData = movies ?: repos.loadMovies()

            withContext(Dispatchers.Main) {
                movies = moviesData
                adapter.submitList(moviesData)
            }*/
        }
    }
}

interface MoviesListClickListener {
    fun onMovieSelected(movie: MovieData)
}