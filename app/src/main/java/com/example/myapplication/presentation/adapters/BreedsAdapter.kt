package com.example.myapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.models.Breed
import kotlinx.android.synthetic.main.item_breed.view.*

class BreedsAdapter : RecyclerView.Adapter<BreedsAdapter.BreedsViewHolder>() {

    private var breeds: List<Breed> = ArrayList()

    fun setBreeds(words: List<Breed>) {
        this.breeds = words
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BreedsViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_breed, viewGroup, false)
        return BreedsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun onBindViewHolder(viewHolder: BreedsViewHolder, i: Int) {
        viewHolder.bind(breeds[i])
    }

    inner class BreedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(breed: Breed) {
            itemView.let {
                it.tvBreed.text = java.lang.String.format("Breed: %s (%s)", breed.name, breed.origin)
                it.tvDescription.text = breed.description
                it.tvWikiUrl.text = breed.wikipediaUrl
            }
        }

    }
}