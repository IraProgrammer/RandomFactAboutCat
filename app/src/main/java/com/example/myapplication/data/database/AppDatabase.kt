package com.example.myapplication.data.database

import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.database.models.FactDb

@Database(
    entities = [FactDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun factDao(): FactDao

    companion object {
        const val DATABASE_NAME = "AnimalsFacts"
    }
}