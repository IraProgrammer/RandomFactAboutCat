package com.example.myapplication.data.repositories

import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.mappers.toModel
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.data.network.models.AddCat
import com.example.myapplication.data.network.models.Response
import com.example.myapplication.domain.models.Cat
import com.example.myapplication.domain.repositories.CatsRepository
import io.reactivex.Single

class CatsRepositoryImpl(private val catsApi: CatsApi, private val factDao: FactDao) :
    CatsRepository {

    override fun loadRandomCat(): Single<Cat> {
        return catsApi.getRandomCat()
            .map { it[0].toModel() }
            //.doOnSuccess { fact -> saveFactToDb(fact) }
    }

    override fun addToFavourite(imageId: String): Single<Response> {
        return catsApi.addCatToFavourites(AddCat(imageId, "123"))
    }

//    override fun saveFactToDb(cat: Cat) {
//        return factDao.insert(cat.toDbModel())
//    }

}