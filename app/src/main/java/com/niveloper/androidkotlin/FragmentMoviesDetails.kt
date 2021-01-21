package com.niveloper.androidkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMoviesDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMoviesDetails : Fragment() {
    var listener: MovieDetailsBackClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем данные по ключу и отрисовываем их на фрагменте.
        val movie = arguments?.getSerializable(PARAM_MOVIE_DATA) as? MovieData ?: return
        initMovieData(movie)
        view.findViewById<RecyclerView>(R.id.rv_actors).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val adapter = AdapterMovieDetails()
            this.adapter = adapter
            adapter.submitList(movie.cast)
        }

        view.findViewById<View>(R.id.back_text).setOnClickListener {
            listener?.onMovieDeselected()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieDetailsBackClickListener)
            listener = context
    }

//    override fun onStart() {
//        super.onStart()
//        view!!.findViewById<View>(R.id.back_text).setOnClickListener {
//            listener?.onMovieDeselected()
//        }
//    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    /**
     * Метод для отрисовки нужных данных при клике на нужную панель с фильмом.
     */
    private fun initMovieData(movie: MovieData) {
        view?.findViewById<TextView>(R.id.movie_naming)?.text = movie.name
        view?.findViewById<ImageView>(R.id.movie_img)?.setImageResource(movie.logo)
        view?.findViewById<TextView>(R.id.movie_aging)?.text = getString(R.string.aging_string, movie.aging)
        view?.findViewById<TextView>(R.id.storyline)?.text = movie.storyLine
        view?.findViewById<TextView>(R.id.genre_movie)?.text = movie.genre
        view?.findViewById<TextView>(R.id.reviews_movie)?.text = movie.genre
        view?.findViewById<RatingBar>(R.id.ratingBar_movie)?.rating = movie.rating
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val backTv = view.findViewById<TextView>(R.id.back_text).setOnClickListener {
//            val frag = FragmentMoviesList()
//            activity!!.supportFragmentManager.beginTransaction()
//                .replace(this.id, frag, null)
//                .addToBackStack(null)
//                .commit()
//        }
//    }


    companion object {
        private const val PARAM_MOVIE_DATA = "movie_data"
        fun newInstance(movie: MovieData) = FragmentMoviesDetails().also {
            val arg = bundleOf(PARAM_MOVIE_DATA to movie)
            it.arguments = arg
        }
    }
}

interface MovieDetailsBackClickListener {
    fun onMovieDeselected()
}