package com.example.myapplication.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.presentation.GlideApp
import kotlinx.android.synthetic.main.item_favourite.view.*

class FavouritesAdapter() : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

    private var favourites: List<FavouriteCat> = ArrayList()

    fun setFavourites(words: List<FavouriteCat>) {
        this.favourites = words
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FavouritesViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_favourite, viewGroup, false)
        return FavouritesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favourites.size
    }

    override fun onBindViewHolder(viewHolder: FavouritesViewHolder, i: Int) {
        viewHolder.bind(favourites[i])
    }

    inner class FavouritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cat: FavouriteCat) {
            itemView.let {
                GlideApp.with(it.context)
                    .load(cat.imageUrl)
                    .placeholder(R.drawable.placeholder_cat)
                    .into(it.ivFavouriteCat)
            }
        }

    }
}