package com.example.myapplication.di.modules

import dagger.Provides
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.data.repositories.BreedsRepositoryImpl
import com.example.myapplication.data.repositories.FavouritesRepositoryImpl
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.interactors.BreedsInteractor
import com.example.myapplication.domain.repositories.FavouritesRepository
import com.example.myapplication.domain.interactors.FavouritesInteractor
import com.example.myapplication.domain.repositories.BreedsRepository
import dagger.Module


@Module
class BreedsModule {

    @Provides
    @PerFragment
    internal fun provideBreedsInteractor(breedsRepository: BreedsRepository) = BreedsInteractor(breedsRepository)

    @Provides
    @PerFragment
    internal fun provideBreedsRepository(catsApi: CatsApi, factDao: FactDao): BreedsRepository {
        return BreedsRepositoryImpl(catsApi, factDao)
    }
}