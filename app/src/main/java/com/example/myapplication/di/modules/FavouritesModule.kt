package com.example.myapplication.di.modules

import dagger.Provides
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.network.CatsApi
import com.example.myapplication.data.repositories.FavouritesRepositoryImpl
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.repositories.FavouritesRepository
import com.example.myapplication.domain.interactors.FavouritesInteractor
import dagger.Module


@Module
class FavouritesModule {

    @Provides
    @PerFragment
    internal fun provideFavouritesInteractor(favouritesRepository: FavouritesRepository) = FavouritesInteractor(favouritesRepository)

    @Provides
    @PerFragment
    internal fun provideFavouritesRepository(catsApi: CatsApi, factDao: FactDao): FavouritesRepository {
        return FavouritesRepositoryImpl(catsApi, factDao)
    }
}