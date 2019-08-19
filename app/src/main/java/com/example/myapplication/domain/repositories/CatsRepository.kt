package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.models.Cat
import io.reactivex.Single

interface CatsRepository {
    fun loadRandomCat(): Single<Cat>
    fun addToFavourite(imageId: String): Single<Any>
}