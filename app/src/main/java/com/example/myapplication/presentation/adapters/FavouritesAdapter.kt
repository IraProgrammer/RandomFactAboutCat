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

    private var words: List<FavouriteCat> = ArrayList()

    fun setFavourites(words: List<FavouriteCat>) {
        this.words = words
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FavouritesViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_favourite, viewGroup, false)
        return FavouritesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(viewHolder: FavouritesViewHolder, i: Int) {
        viewHolder.bind(words[i])
    }

    inner class FavouritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cat: FavouriteCat) {
            itemView.let {
                GlideApp.with(it.context)
                    .load(cat.image.url)
                    .into(it.ivFavouriteCat)
            }
        }

    }
}