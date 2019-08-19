package com.example.myapplication.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddCat(
    @SerializedName("image_id")
    @Expose
    val imageId: String
)

data class FavouriteCatNw(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("image")
    @Expose
    var image: ImageNw
)

data class ImageNw(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String
)

