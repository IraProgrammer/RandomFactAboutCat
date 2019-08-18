package com.example.myapplication.presentation.views

import com.example.myapplication.domain.models.FavouriteCat

interface FavouritesView: BaseView {
    fun onSuccessGetFavourites(cats: List<FavouriteCat>)
    fun onError()
}