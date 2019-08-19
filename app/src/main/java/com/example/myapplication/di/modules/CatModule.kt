package com.example.myapplication.di.modules

import dagger.Provides
import com.example.myapplication.data.database.dao.BreedsDao
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.data.repositories.CatsRepositoryImpl
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.repositories.CatsRepository
import com.example.myapplication.domain.interactors.CatInteractor
import dagger.Module


@Module
class CatModule {

    @Provides
    @PerFragment
    internal fun provideFactsInteractor(catsRepository: CatsRepository) = CatInteractor(catsRepository)

    @Provides
    @PerFragment
    internal fun provideCatRepository(catsApi: CatsApi): CatsRepository {
        return CatsRepositoryImpl(catsApi)
    }
}