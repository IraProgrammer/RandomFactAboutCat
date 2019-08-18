package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.FavouriteCat
import io.reactivex.Single

interface FavouritesRepository {
    fun loadFavourites(): Single<List<FavouriteCat>>
    //fun saveFactToDb(cat: Cat)
}