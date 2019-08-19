package com.example.myapplication.data.database

import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.myapplication.data.database.dao.BreedsDao
import com.example.myapplication.data.database.models.BreedDb

@Database(
    entities = [BreedDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun breedsDao(): BreedsDao

    companion object {
        const val DATABASE_NAME = "CatsDatabase"
    }
}