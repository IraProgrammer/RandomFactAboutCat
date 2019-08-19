package com.example.myapplication.data.repositories

import com.example.myapplication.data.database.dao.BreedsDao
import com.example.myapplication.data.mappers.toDbModel
import com.example.myapplication.data.mappers.toModel
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.domain.models.Breed
import com.example.myapplication.domain.repositories.BreedsRepository
import io.reactivex.Single

class BreedsRepositoryImpl(private val catsApi: CatsApi, private val breedsDao: BreedsDao) :
    BreedsRepository {

    override fun getBreedsFromDb(): Single<List<Breed>> {
        return getFromDb()
            .flattenAsObservable { list -> list }
            .map { it.toModel() }
            .toList()
    }

    override fun loadBreedsFromNetwork(): Single<List<Breed>> {
        return catsApi.getBreeds()
            .flattenAsObservable { list -> list }
            .map { it.toModel() }
            .doOnNext { breed -> saveBreedToDb(breed) }
            .toList()
    }

    fun saveBreedToDb(breed: Breed) {
        breedsDao.insert(breed.toDbModel())
    }

    fun getFromDb() = breedsDao.getAll()
}