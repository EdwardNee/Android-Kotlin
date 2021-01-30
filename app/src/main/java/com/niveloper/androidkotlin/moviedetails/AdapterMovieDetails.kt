package com.niveloper.androidkotlin.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.niveloper.androidkotlin.R
import com.niveloper.androidkotlin.datastore.ActorData

class AdapterMovieDetails : ListAdapter<ActorData, ActorViewHolder>(ActorDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }
}

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val actorImg: ImageView = itemView.findViewById(R.id.actor_img)
    private val actorName: TextView = itemView.findViewById(R.id.actor_name)

    fun onBind(item: ActorData) {
        val context = itemView.context
        Glide.with(context)
            .load(item.imageUrl)
            .into(actorImg)
        actorName.text = item.name
    }
}

/**
 * Callback class for updating difference data of Actors.
 */
class ActorDiffCallback : DiffUtil.ItemCallback<ActorData>() {
    override fun areItemsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
        return oldItem == newItem
    }
}