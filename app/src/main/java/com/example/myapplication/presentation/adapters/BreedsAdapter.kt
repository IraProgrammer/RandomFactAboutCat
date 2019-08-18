package com.example.myapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.models.Breed
import kotlinx.android.synthetic.main.item_breed.view.*

class BreedsAdapter() : RecyclerView.Adapter<BreedsAdapter.BreedsViewHolder>() {

    private var words: List<Breed> = ArrayList()

    fun setBreeds(words: List<Breed>) {
        this.words = words
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): BreedsViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_breed, viewGroup, false)
        return BreedsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(viewHolder: BreedsViewHolder, i: Int) {
        viewHolder.bind(words[i])
    }

    inner class BreedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(breed: Breed) {
            itemView.let {
                it.tvBreed.text = breed.name
                it.tvDescription.text = breed.description
            }
        }

    }
}