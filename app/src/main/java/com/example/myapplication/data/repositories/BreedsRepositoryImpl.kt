package com.example.myapplication.data.repositories

import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.mappers.toModel
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.domain.models.Breed
import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.domain.repositories.BreedsRepository
import com.example.myapplication.domain.repositories.FavouritesRepository
import io.reactivex.Single

class BreedsRepositoryImpl(private val catsApi: CatsApi, private val factDao: FactDao) :
    BreedsRepository {
    override fun loadBreeds(): Single<List<Breed>> {
        return catsApi.getBreeds()
            .flattenAsObservable { list -> list }
            .map { it.toModel() }
            .toList()
        //.doOnSuccess { fact -> saveFactToDb(fact) }
    }
}