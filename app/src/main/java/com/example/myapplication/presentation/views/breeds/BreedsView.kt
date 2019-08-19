package com.example.myapplication.presentation.views.breeds

import com.example.myapplication.domain.models.Breed
import com.example.myapplication.presentation.views.BaseView

interface BreedsView: BaseView {
    fun onSuccessGetBreeds(breed: List<Breed>)
    fun onError()
    fun showProgressBar()
    fun hideProgressBar()
}