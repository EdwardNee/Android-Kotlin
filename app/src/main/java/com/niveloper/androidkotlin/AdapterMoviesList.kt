package com.niveloper.androidkotlin

import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class AdapterMoviesList : ListAdapter<MovieData, MovieViewHolder>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val movieName :TextView = view.findViewById(R.id.movie_naming)
    private val movieImg : ImageView = view.findViewById(R.id.movie_img)
    private val movieAging : TextView = view.findViewById(R.id.movie_aging)
    private val movieGenre: TextView = view.findViewById(R.id.genre_movie)
    private val movieRating: RatingBar = view.findViewById(R.id.ratingBar_movie)
    private val movieReviews: TextView = view.findViewById(R.id.reviews_movie)
    private val movieDuration: TextView = view.findViewById(R.id.movie_duration)
    private val movieLiked: TextView = view.findViewById(R.id.reaction)

    fun onBind(item : MovieData){

    }
}

/**
 * Callback class for updating difference list of movies.
 */
class MovieDiffCallback : DiffUtil.ItemCallback<MovieData>() {
    override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
        return oldItem == newItem
    }

}