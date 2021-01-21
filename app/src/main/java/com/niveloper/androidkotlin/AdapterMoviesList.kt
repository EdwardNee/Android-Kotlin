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

class AdapterMoviesList(private val onClickCard: (item: MovieData) -> Unit) :
    ListAdapter<MovieData, MovieViewHolder>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item, onClickCard)
    }
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val movieName: TextView = view.findViewById(R.id.movie_naming)
    private val movieAging: TextView = view.findViewById(R.id.movie_aging)
    private val movieGenre: TextView = view.findViewById(R.id.genre_movie)
    private val movieReviews: TextView = view.findViewById(R.id.reviews_movie)
    private val movieDuration: TextView = view.findViewById(R.id.movie_duration)
    private val movieLiked: ImageView = view.findViewById(R.id.reaction)
    private val movieImg: ImageView = view.findViewById(R.id.movie_img)
    private val movieRating: RatingBar = view.findViewById(R.id.ratingBar_movie)

    fun onBind(item: MovieData, onClickCard: (item: MovieData) -> Unit) {
        movieImg.setImageResource(item.logo)
        movieName.text = item.name
        movieAging.text = "13"//itemView.context.getString(item.aging)
        movieGenre.text = item.genre
        movieReviews.text = "tt2"//itemView.context.getString(item.reviewsCnt)
        movieDuration.text = "133"//itemView.context.getString(item.time)
        movieLiked.setImageResource(if (item.isLiked) R.drawable.like else R.drawable.dislike)
        movieRating.rating = item.rating

        itemView.setOnClickListener { onClickCard(item) }
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