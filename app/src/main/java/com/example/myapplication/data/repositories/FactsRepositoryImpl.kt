package com.example.myapplication.data.repositories

import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.database.mappers.toDbModel
import com.example.myapplication.data.database.mappers.toModel
import com.example.myapplication.data.database.models.FactDb
import com.example.myapplication.data.network.FactsApi
import com.example.myapplication.data.network.models.FactNw
import com.example.myapplication.domain.Fact
import com.example.myapplication.domain.FactsRepository
import dagger.Provides
import io.reactivex.Completable
import io.reactivex.Single

class FactsRepositoryImpl(private val factsApi: FactsApi, private val factDao: FactDao) : FactsRepository {
    override fun loadFact(): Single<Fact> {
        return factsApi.getRandomFact()
            .map { it.toModel() }
            .doOnSuccess { fact -> saveFactToDb(fact) }
    }

    override fun saveFactToDb(fact: Fact) {
        return factDao.insert(fact.toDbModel())
    }

}