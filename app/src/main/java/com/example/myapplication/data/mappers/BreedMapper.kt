package com.example.myapplication.data.mappers

import com.example.myapplication.data.database.models.BreedDb
import com.example.myapplication.data.network.models.BreedNw
import com.example.myapplication.domain.models.Breed

fun BreedNw.toModel() = Breed(
    id = this.id,
    description = this.description,
    name = this.name,
    origin = this.origin,
    wikipediaUrl = this.wikipediaUrl
)

fun Breed.toDbModel() = BreedDb(
    id = this.id,
    description = this.description,
    name = this.name,
    origin = this.origin,
    wikipediaUrl = this.wikipediaUrl
)

fun BreedDb.toModel() = Breed(
    id = this.id,
    description = this.description,
    name = this.name,
    origin = this.origin,
    wikipediaUrl = this.wikipediaUrl
)