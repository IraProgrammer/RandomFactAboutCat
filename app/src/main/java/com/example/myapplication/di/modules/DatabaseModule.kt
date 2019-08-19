package com.example.myapplication.di.modules

import android.content.Context
import com.example.myapplication.di.scopes.PerApplication
import dagger.Provides
import androidx.room.Room
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.data.database.AppDatabase.Companion.DATABASE_NAME
import com.example.myapplication.data.database.dao.BreedsDao
import dagger.Module
import javax.inject.Named

@Module
class DatabaseModule {

    @Provides
    @PerApplication
    fun provideDatabase(@Named("AppContext") context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    @Provides
    @PerApplication
    fun provideFactDao(database: AppDatabase): BreedsDao {
        return database.breedsDao()
    }
}