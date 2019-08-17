package com.example.myapplication.di.modules

import android.content.Context
import com.example.myapplication.di.scopes.PerApplication
import dagger.Provides
import androidx.room.Room
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.data.database.AppDatabase.Companion.DATABASE_NAME
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.network.FactsApi
import com.example.myapplication.data.repositories.FactsRepositoryImpl
import com.example.myapplication.di.scopes.PerActivity
import com.example.myapplication.domain.FactsRepository
import com.example.myapplication.domain.interactors.FactsInteractor
import dagger.Module
import javax.inject.Named


@Module
class FactsModule {

    @Provides
    @PerActivity
    internal fun provideFactsInteractor(factsRepository: FactsRepository) = FactsInteractor(factsRepository)

    @Provides
    @PerActivity
    internal fun provideFactsRepository(factsApi: FactsApi, factDao: FactDao): FactsRepository {
        return FactsRepositoryImpl(factsApi, factDao)
    }
}