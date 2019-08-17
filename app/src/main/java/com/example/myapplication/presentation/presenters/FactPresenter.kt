package com.example.myapplication.presentation.presenters

import com.example.myapplication.FactsApp
import com.example.myapplication.data.database.dao.FactDao
import com.example.myapplication.data.network.FactsApi
import com.example.myapplication.data.repositories.FactsRepositoryImpl
import com.example.myapplication.di.components.AppComponent
import com.example.myapplication.di.components.FactsComponent
import com.example.myapplication.di.modules.FactsModule
import com.example.myapplication.domain.FactsRepository
import com.example.myapplication.domain.interactors.FactsInteractor
import com.example.myapplication.presentation.views.FactView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class FactPresenter : MvpPresenter<FactView>() {

    @Inject
    lateinit var factsInteractor: FactsInteractor

    init {
        FactsApp.appComponent?.addFactsComponent(FactsModule())?.inject(this)
    }

    var compositeDisposable = CompositeDisposable()

    fun loadFact() {
        compositeDisposable.add(factsInteractor.loadFact()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ fact -> viewState.onSuccessGetFact(fact) }, { viewState.onError() })
        )
    }
}