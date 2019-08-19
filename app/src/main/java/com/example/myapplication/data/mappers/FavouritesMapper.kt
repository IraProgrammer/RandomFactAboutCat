package com.example.myapplication.data.mappers

import com.example.myapplication.data.network.models.FavouriteCatNw
import com.example.myapplication.domain.models.FavouriteCat

fun FavouriteCatNw.toModel() = FavouriteCat(
    this.id,
    this.image.url
)