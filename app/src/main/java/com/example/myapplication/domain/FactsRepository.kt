package com.example.myapplication.domain

import io.reactivex.Completable
import io.reactivex.Single

interface FactsRepository {
    fun loadFact(): Single<Fact>
    fun saveFactToDb(fact: Fact)
}