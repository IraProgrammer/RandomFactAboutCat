package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.database.models.BreedDb
import io.reactivex.Single

@Dao
interface BreedsDao {
    @Insert
    fun insert(breedDb: BreedDb)

    @Query("SELECT * FROM BreedDb")
    fun getAll(): Single<List<BreedDb>>
}