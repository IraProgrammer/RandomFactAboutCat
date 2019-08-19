package com.example.myapplication.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BreedDb(
    @PrimaryKey
    var id: String,
    var description: String,
    var name: String,
    var origin: String,
    var wikipediaUrl: String?
)