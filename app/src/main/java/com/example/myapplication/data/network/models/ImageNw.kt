package com.example.myapplication.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageNw(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String
)