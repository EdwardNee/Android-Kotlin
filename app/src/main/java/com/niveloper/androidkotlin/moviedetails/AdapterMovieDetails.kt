package com.niveloper.androidkotlin.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.niveloper.androidkotlin.R
import com.niveloper.androidkotlin.data.ActorData

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

class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val actorImg: ImageView = view.findViewById(R.id.actor_img)
    private val actorName: TextView = view.findViewById(R.id.actor_name)

    fun onBind(item: ActorData) {
        actorImg.setImageResource(item.logo)
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