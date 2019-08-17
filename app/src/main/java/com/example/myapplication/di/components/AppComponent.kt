package com.example.myapplication.di.components

import com.example.myapplication.di.modules.ContextModule
import com.example.myapplication.di.modules.DatabaseModule
import com.example.myapplication.di.modules.FactsModule
import com.example.myapplication.di.modules.NetworkModule
import com.example.myapplication.di.scopes.PerApplication
import dagger.Component
import java.util.*

@PerApplication
@Component(
    modules = [ContextModule::class, DatabaseModule::class, NetworkModule::class]
)
interface AppComponent {
    fun addFactsComponent(factsModule: FactsModule): FactsComponent
}