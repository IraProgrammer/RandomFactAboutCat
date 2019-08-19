package com.example.myapplication.presentation.views.rendom_cats

import com.example.myapplication.domain.models.Cat
import com.example.myapplication.presentation.views.BaseView

interface CatView: BaseView {
    fun onSuccessGetCat(cat: Cat)
    fun onSuccessAddToFavourites()
    fun onError()
    fun uncheckedLike()
    fun disabledLike()
    fun enabledLike()
}