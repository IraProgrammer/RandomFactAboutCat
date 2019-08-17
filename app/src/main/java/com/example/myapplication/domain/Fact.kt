package com.example.myapplication.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Fact(
    @PrimaryKey
    val id: String,
    val text: String,
    val type: String
)