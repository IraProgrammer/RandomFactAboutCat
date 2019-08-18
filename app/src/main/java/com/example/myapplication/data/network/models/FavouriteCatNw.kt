package com.example.myapplication.data.network.models

import android.media.Image
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FavouriteCatNw(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("image")
    @Expose
    var image: ImageNw,

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