package com.example.myapplication.data.mappers

import com.example.myapplication.data.network.models.BreedNw
import com.example.myapplication.domain.models.Breed

fun BreedNw.toModel() = Breed(
    description = this.description,
    id = this.id,
    name = this.name,
    origin = this.origin
    //wikipediaUrl = this.wikipediaUrl
)