package com.niveloper.androidkotlin.moviedetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.niveloper.androidkotlin.R
import com.niveloper.androidkotlin.datastore.MovieData
import kotlinx.coroutines.launch

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
        val movieId = arguments?.getSerializable(PARAM_MOVIE_ID) as? Int ?: return
//        initMovieData(movieId)
        view.findViewById<RecyclerView>(R.id.rv_actors).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val adapter = AdapterMovieDetails()
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            this.adapter = adapter
//            adapter.submitList(movieId.cast)
        }

        view.findViewById<View>(R.id.back_text).setOnClickListener {
            listener?.onMovieDeselected()
        }

        lifecycleScope.launch {
            JsonLoad
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
        view?.findViewById<TextView>(R.id.movie_naming)?.text = movie.title
//        view?.findViewById<ImageView>(R.id.movie_img)?.load(movie.logoUrl)
        Glide.with(requireContext())
            .load(movie.logoUrl)
            .into(view?.findViewById<ImageView>(R.id.movie_img)!!)
        view?.findViewById<TextView>(R.id.movie_aging)?.text =
            getString(R.string.aging_string, movie.aging)
        view?.findViewById<TextView>(R.id.storyline)?.text = movie.storyLine
        view?.findViewById<TextView>(R.id.genre_movie)?.text = movie.genres.joinToString { it.name }
        view?.findViewById<TextView>(R.id.reviews_movie)?.text =
            getString(R.string.reviews_string, movie.reviewsCnt)
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
        private const val PARAM_MOVIE_ID = "movie_data_id"
        fun newInstance(movieId: Int) = FragmentMoviesDetails().also {
            val arg = bundleOf(PARAM_MOVIE_ID to movieId)
            it.arguments = arg
        }
    }
}

interface MovieDetailsBackClickListener {
    fun onMovieDeselected()
}

