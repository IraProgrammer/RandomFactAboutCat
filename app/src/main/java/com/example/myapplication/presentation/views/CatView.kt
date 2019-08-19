package com.example.myapplication.presentation.views

import com.example.myapplication.domain.models.Cat

interface CatView: BaseView {
    fun onSuccessGetCat(cat: Cat)
    fun onSuccessAddToFavourites()
    fun onError()
    fun uncheckedLike()
    fun disabledLike()
    fun enabledLike()
}