package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.components.AppComponent
import com.example.myapplication.di.components.DaggerAppComponent
import com.example.myapplication.di.modules.ContextModule


class FactsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    companion object {
        var appComponent: AppComponent? = null
            private set
    }
}