package com.example.myapplication.domain.interactors

import com.example.myapplication.domain.repositories.CatsRepository
import io.reactivex.schedulers.Schedulers

class CatInteractor(var catsRepository: CatsRepository) {

    fun loadCat() = catsRepository.loadRandomCat()
        .subscribeOn(Schedulers.io())

    fun addToFavourites(imageId: String) = catsRepository.addToFavourite(imageId)
        .subscribeOn(Schedulers.io())
}