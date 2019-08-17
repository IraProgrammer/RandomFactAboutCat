package com.example.myapplication.presentation.views

import com.example.myapplication.domain.Fact
import moxy.MvpView

interface FactView: MvpView {
    fun onSuccessGetFact(fact: Fact)
    fun onError()
}