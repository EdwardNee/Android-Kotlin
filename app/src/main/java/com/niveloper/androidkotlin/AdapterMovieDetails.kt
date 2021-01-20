package com.niveloper.androidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class AdapterMovieDetails : ListAdapter<ActorData, ActorViewHolder>(ActorDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

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