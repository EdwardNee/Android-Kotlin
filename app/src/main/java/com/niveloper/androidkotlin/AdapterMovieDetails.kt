package com.niveloper.androidkotlin

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AdapterMovieDetails : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}

/**
 * Callback class for updating data of Actors.
 */
class DiffCallback : DiffUtil.ItemCallback<ActorData>() {
    override fun areItemsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
        return oldItem == newItem
    }
}