package com.example.myapplication.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BreedDb(

    var description: String,

    @PrimaryKey
    var id: String,

    var name: String,

    var origin: String,

    var wikipediaUrl: String?
)