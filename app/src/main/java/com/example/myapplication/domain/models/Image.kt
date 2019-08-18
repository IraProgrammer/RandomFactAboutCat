package com.example.myapplication.domain.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("url")
    @Expose
    var url: String
)