package com.example.myapplication.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FactNw (
    @SerializedName("_id")
    @Expose
    val id:String,
    @SerializedName("text")
    @Expose
    val text:String,
    @SerializedName("type")
    @Expose
    val type:String
)