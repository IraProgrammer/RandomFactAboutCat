package com.example.myapplication.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FavouriteCat(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("image")
    @Expose
    var image: Image,

    @SerializedName("image_id")
    @Expose
    var imageId: String,

    @SerializedName("sub_id")
    @Expose
    var subId: String,

    @SerializedName("user_id")
    @Expose
    var userId: String
)