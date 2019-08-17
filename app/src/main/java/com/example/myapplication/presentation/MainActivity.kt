package com.example.myapplication.presentation

import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.domain.Fact
import com.example.myapplication.presentation.presenters.FactPresenter
import com.example.myapplication.presentation.views.FactView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), FactView {

    @InjectPresenter
    internal lateinit var factPresenter: FactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext.setOnClickListener { factPresenter.loadFact() }
    }

    override fun onSuccessGetFact(fact: Fact) {
        tvFact.text = fact.text
    }

    override fun onError() {
        Toast.makeText(this, "Проверьте интернет-соединение и попробуйте еще раз", Toast.LENGTH_LONG).show()
    }
}
