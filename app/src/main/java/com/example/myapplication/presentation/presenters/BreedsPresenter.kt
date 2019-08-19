package com.example.myapplication.presentation.presenters

import com.example.myapplication.CatsApp
import com.example.myapplication.di.modules.BreedsModule
import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.FavouritesModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.domain.interactors.BreedsInteractor
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.domain.interactors.FavouritesInteractor
import com.example.myapplication.presentation.views.BreedsView
import com.example.myapplication.presentation.views.CatView
import com.example.myapplication.presentation.views.FavouritesView
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
}