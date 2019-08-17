package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.data.database.models.FactDb
import io.reactivex.Completable

@Dao
interface FactDao {
    @Insert
    fun insert(factDb: FactDb)
}