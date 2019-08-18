package com.example.myapplication.domain.interactors

import com.example.myapplication.domain.repositories.FavouritesRepository
import io.reactivex.schedulers.Schedulers

class FavouritesInteractor(var favouritesRepository: FavouritesRepository) {

    fun loadFavourites() = favouritesRepository.loadFavourites()
        .subscribeOn(Schedulers.io())
}