package com.example.myapplication.di.components

import com.example.myapplication.di.modules.BreedsModule
import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.FavouritesModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.di.scopes.PerActivity
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.presentation.presenters.CatPresenter
import dagger.Subcomponent

@PerActivity
@Subcomponent(
    modules = [MainModule::class]
)
interface MainComponent{
    fun addFavouritesComponent(favouritesModule: FavouritesModule): FavouritesComponent
    fun addCatComponent(catModule: CatModule): CatComponent
    fun addBreedsComponent(breedsModule: BreedsModule): BreedsComponent
}