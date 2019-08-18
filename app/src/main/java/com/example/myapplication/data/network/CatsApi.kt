package com.example.myapplication.data.network

import com.example.myapplication.data.network.models.*
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CatsApi{
    @GET("images/search")
    fun getRandomCat(): Single<List<CatNw>>

    @POST("favourites")
    fun addCatToFavourites(@Body addCat: AddCat): Single<Response>

    @GET("favourites")
    fun getFavourites(): Single<List<FavouriteCatNw>>

    @GET("breeds")
    fun getBreeds(): Single<List<BreedNw>>
}