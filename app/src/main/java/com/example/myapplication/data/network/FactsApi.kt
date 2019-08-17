package com.example.myapplication.data.network

import com.example.myapplication.data.database.models.FactDb
import com.example.myapplication.data.network.models.FactNw
import io.reactivex.Single
import retrofit2.http.GET

interface FactsApi{
    @GET("facts/random")
    fun getRandomFact(): Single<FactNw>
}