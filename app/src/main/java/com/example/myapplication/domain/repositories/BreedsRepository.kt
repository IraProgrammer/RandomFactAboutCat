package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.Breed
import com.example.myapplication.domain.models.FavouriteCat
import io.reactivex.Single

interface BreedsRepository {

    fun loadBreedsFromNetwork(): Single<List<Breed>>

    fun getBreedsFromDb(): Single<List<Breed>>
}