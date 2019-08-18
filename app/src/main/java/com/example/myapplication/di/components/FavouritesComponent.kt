package com.example.myapplication.di.components

import com.example.myapplication.di.modules.FavouritesModule
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.interactors.FavouritesInteractor
import com.example.myapplication.presentation.presenters.FavoritesPresenter
import dagger.Subcomponent

@PerFragment
@Subcomponent(
    modules = [FavouritesModule::class]
)
interface FavouritesComponent {
    fun inject(favouritesInteractor: FavouritesInteractor)
    fun inject(favoritesPresenter: FavoritesPresenter)
}