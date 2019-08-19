package com.example.myapplication.data.mappers

import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.data.network.models.FavouriteCatNw
import com.example.myapplication.data.network.models.ImageNw
import com.example.myapplication.domain.models.Image

fun FavouriteCatNw.toModel() = FavouriteCat(
    this.id,
    this.image.toModel(),
    this.imageId,
    this.subId,
    this.userId
)

fun ImageNw.toModel() = Image(this.id, this.url)