package com.example.myapplication.presentation.presenters

import com.example.myapplication.CatsApp
import com.example.myapplication.di.modules.BreedsModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.domain.interactors.BreedsInteractor
import com.example.myapplication.presentation.views.breeds.BreedsView
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class BreedsPresenter : BasePresenter<BreedsView>() {

    @Inject
    lateinit var breedsInteractor: BreedsInteractor

    init {
        CatsApp.appComponent?.addMainComponent(MainModule())?.addBreedsComponent(BreedsModule())?.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadBreeds()
    }

    fun loadBreeds() {
        viewState.showProgressBar()
        add(
            breedsInteractor.loadBreeds()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.hideProgressBar() }
                .subscribe({ viewState.onSuccessGetBreeds(it) }, { viewState.onError() })
        )
    }

    fun loadBreedsFromNetworkOnly() {
        viewState.showProgressBar()
        add(
            breedsInteractor.loadBreedsFromNetworkOnly()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.hideProgressBar() }
                .subscribe({ viewState.onSuccessGetBreeds(it) }, { viewState.onError() })
        )
    }
}