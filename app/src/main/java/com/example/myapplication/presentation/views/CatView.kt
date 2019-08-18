package com.example.myapplication.presentation.views

import com.example.myapplication.domain.models.Cat

interface CatView: BaseView {
    fun onSuccessGetFact(cat: Cat)
    fun onSuccessAddToFavourites()
    fun onError()
}