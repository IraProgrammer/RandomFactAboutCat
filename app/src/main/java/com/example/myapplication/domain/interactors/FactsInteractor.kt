package com.example.myapplication.domain.interactors

import com.example.myapplication.domain.FactsRepository
import io.reactivex.schedulers.Schedulers

class FactsInteractor(var factsRepository: FactsRepository) {

    fun loadFact() = factsRepository.loadFact()
        .subscribeOn(Schedulers.io())
}