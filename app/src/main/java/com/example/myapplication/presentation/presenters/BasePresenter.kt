package com.example.myapplication.presentation.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<BaseView : MvpView> : MvpPresenter<BaseView>() {

    var conpositeDisposable: CompositeDisposable? = null

    fun add(disposable: Disposable) {
        if (conpositeDisposable == null) conpositeDisposable = CompositeDisposable()
        conpositeDisposable?.add(disposable)
    }

    override fun detachView(view: BaseView) {
        super.detachView(view)
        conpositeDisposable?.clear()
    }
}