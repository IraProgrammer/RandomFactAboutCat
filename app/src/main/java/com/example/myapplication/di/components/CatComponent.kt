package com.example.myapplication.di.components

import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.FavouritesModule
import com.example.myapplication.di.scopes.PerActivity
import com.example.myapplication.di.scopes.PerFragment
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.presentation.presenters.CatPresenter
import dagger.Subcomponent

@PerFragment
@Subcomponent(
    modules = [CatModule::class]
)
interface CatComponent {
    fun inject(catInteractor: CatInteractor)
    fun inject(catPresenter: CatPresenter)
}