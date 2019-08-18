package com.example.myapplication.presentation.views

import com.example.myapplication.domain.models.Breed

interface BreedsView: BaseView {
    fun onSuccessGetBreeds(breed: List<Breed>)
    fun onError()
}