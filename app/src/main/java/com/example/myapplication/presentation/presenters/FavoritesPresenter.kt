package com.example.myapplication.presentation.presenters

import com.example.myapplication.CatsApp
import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.FavouritesModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.domain.interactors.FavouritesInteractor
import com.example.myapplication.presentation.views.CatView
import com.example.myapplication.presentation.views.FavouritesView
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter : BasePresenter<FavouritesView>() {

    @Inject
    lateinit var favouritesInteractor: FavouritesInteractor

    init {
        CatsApp.appComponent?.addMainComponent(MainModule())?.addFactsComponent(FavouritesModule())?.inject(this)
    }

    fun loadFavourites() {
        add(
            favouritesInteractor.loadFavourites()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.onSuccessGetFavourites(it) }, { viewState.onError() })
        )
    }
}