package com.example.myapplication.presentation.presenters

import com.example.myapplication.CatsApp
import com.example.myapplication.di.modules.CatModule
import com.example.myapplication.di.modules.MainModule
import com.example.myapplication.domain.interactors.CatInteractor
import com.example.myapplication.presentation.views.rendom_cats.CatView
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

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCat()
    }

    fun loadCat() {
        viewState.disabledLike()
        add(
            catInteractor.loadCat()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    viewState.uncheckedLike()
                }
                .subscribe({ fact ->
                    viewState.enabledLike()
                    viewState.onSuccessGetCat(fact)
                }, { viewState.onError() })
        )
    }

    fun addToFavourites(imageId: String) {
        viewState.disabledLike()
        add(
            catInteractor.addToFavourites(imageId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ viewState.onSuccessAddToFavourites() }, { viewState.onError() })
        )
    }
}