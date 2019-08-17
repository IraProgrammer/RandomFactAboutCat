package com.example.myapplication.di.modules

import android.content.Context
import com.example.myapplication.di.scopes.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class ContextModule(
    @get:Provides
    @get:PerApplication
    @get:Named("AppContext")
    internal val context: Context
)