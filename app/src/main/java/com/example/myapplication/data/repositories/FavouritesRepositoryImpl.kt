package com.example.myapplication.data.repositories

import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.mappers.toModel
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.domain.repositories.FavouritesRepository
import io.reactivex.Single

class FavouritesRepositoryImpl(private val catsApi: CatsApi, private val factDao: FactDao) :
    FavouritesRepository {
    override fun loadFavourites(): Single<List<FavouriteCat>> {
        return catsApi.getFavourites()
            .flattenAsObservable { list -> list }
            .map { it.toModel() }
            .toList()
        //.doOnSuccess { fact -> saveFactToDb(fact) }
    }

//    override fun saveFactToDb(cat: Cat) {
//        return factDao.insert(cat.toDbModel())
//    }

}