package com.niveloper.androidkotlin.features.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.niveloper.androidkotlin.R
import com.niveloper.androidkotlin.datastore.MovieData

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

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val movieName: TextView = itemView.findViewById(R.id.movie_naming)
    private val movieAging: TextView = itemView.findViewById(R.id.movie_aging)
    private val movieGenre: TextView = itemView.findViewById(R.id.genre_movie)
    private val movieReviews: TextView = itemView.findViewById(R.id.reviews_movie)
    private val movieDuration: TextView = itemView.findViewById(R.id.movie_duration)
    private val movieLiked: ImageView = itemView.findViewById(R.id.reaction)
    private val movieImage: ImageView = itemView.findViewById(R.id.movie_img)
    private val movieRating: RatingBar = itemView.findViewById(R.id.ratingBar_movie)

    fun onBind(item: MovieData, onClickCard: (item: MovieData) -> Unit) {
        println("\n THAT IS LOGO ${item.logoUrl}\n")
        movieImage.load(item.logoUrl)
        movieName.text = item.title
        movieAging.text = itemView.context.getString(R.string.aging_string, item.aging)
        movieGenre.text = item.genres.joinToString { it.name }
        movieReviews.text = itemView.context.getString(R.string.reviews_string, item.reviewsCnt)
        movieDuration.text = itemView.context.getString(R.string._137_min_duration, item.time)
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
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
        return oldItem == newItem
    }

}