package com.example.myapplication.presentation.views.favourites

import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.presentation.views.BaseView

interface FavouritesView: BaseView {
    fun onSuccessGetFavourites(cats: List<FavouriteCat>)
    fun onError()
    fun showProgressBar()
    fun hideProgressBar()
}