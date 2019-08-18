package com.example.myapplication.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BreedNw(

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("origin")
    @Expose
    var origin: String

//    @SerializedName("wikipedia_url")
//    @Expose
//    var wikipediaUrl: String?
)