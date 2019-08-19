package com.example.myapplication.domain.interactors

import com.example.myapplication.domain.repositories.BreedsRepository
import com.example.myapplication.domain.repositories.FavouritesRepository
import io.reactivex.schedulers.Schedulers

class BreedsInteractor(var breedsRepository: BreedsRepository) {

    fun loadBreeds() = breedsRepository.loadBreedsFromNetwork()
        .onErrorResumeNext { breedsRepository.getBreedsFromDb() }
        .subscribeOn(Schedulers.io())

    fun loadBreedsFromNetworkOnly() = breedsRepository.loadBreedsFromNetwork()
        .subscribeOn(Schedulers.io())
}