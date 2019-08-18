package com.example.myapplication.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddCat(
    @SerializedName("image_id")
    @Expose
    val imageId: String,
    @SerializedName("sub_id")
    @Expose
    val subId: String
)