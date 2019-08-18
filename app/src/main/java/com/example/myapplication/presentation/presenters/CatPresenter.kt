package com.example.myapplication.presentation.presenters

import com.example.myapplication.CatsApp
import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.presentation.views.CatView
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CatPresenter : BasePresenter<CatView>() {

    @Inject
    lateinit var catInteractor: CatInteractor

    init {
        CatsApp.appComponent?.addMainComponent(MainModule())?.addCatComponent(CatModule())?.inject(this)
    }

    fun loadFact() {
        add(
            catInteractor.loadCat()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ fact -> viewState.onSuccessGetFact(fact) }, { viewState.onError() })
        )
    }

    fun addToFavourites(imageId: String) {
        add(
            catInteractor.addToFavourites(imageId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.onSuccessAddToFavourites() }, { viewState.onError() })
        )
    }
}