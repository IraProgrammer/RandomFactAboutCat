package com.example.myapplication.di.components

import com.example.myapplication.di.modules.ContextModule
import com.example.myapplication.di.modules.DatabaseModule
import com.example.myapplication.di.modules.FactsModule
import com.example.myapplication.di.modules.NetworkModule
import com.example.myapplication.di.scopes.PerActivity
import com.example.myapplication.di.scopes.PerApplication
import com.example.myapplication.domain.interactors.FactsInteractor
import com.example.myapplication.presentation.presenters.FactPresenter
import dagger.Component
import dagger.Subcomponent
import java.util.*

@PerActivity
@Subcomponent(
    modules = [FactsModule::class]
)
interface FactsComponent {
    fun inject(factsInteractor: FactsInteractor)
    fun inject(factsPresenter: FactPresenter)
}