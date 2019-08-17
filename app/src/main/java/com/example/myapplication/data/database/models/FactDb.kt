package com.example.myapplication.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "facts")
data class FactDb(
    @PrimaryKey
    val id: String,
    val text: String,
    val type: String
)