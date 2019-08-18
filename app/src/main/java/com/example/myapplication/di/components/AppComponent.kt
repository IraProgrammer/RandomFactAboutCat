package com.example.myapplication.di.components

import com.example.myapplication.di.modules.*
import com.example.myapplication.di.scopes.PerApplication
import dagger.Component

@PerApplication
@Component(
    modules = [ContextModule::class, DatabaseModule::class, NetworkModule::class]
)
interface AppComponent {
    fun addMainComponent(mainModule: MainModule): MainComponent
}