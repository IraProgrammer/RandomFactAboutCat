package com.example.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.domain.models.Cat
import com.example.myapplication.presentation.presenters.CatPresenter
import com.example.myapplication.presentation.views.CatView
import kotlinx.android.synthetic.main.fragment_cat.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class RandomCatFragment : MvpAppCompatFragment(), CatView {

    @InjectPresenter
    internal lateinit var catPresenter: CatPresenter

    private var catId = ""

    companion object {
        fun newInstance(): RandomCatFragment {
            return RandomCatFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cat, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ibNext.setOnClickListener {
            catPresenter.loadCat()
        }
        chbAddToFavourites.setOnCheckedChangeListener { _, b ->
            if (b) catPresenter.addToFavourites(catId)
        }
    }

    override fun enabledLike() {
        chbAddToFavourites.isEnabled = true
    }

    override fun disabledLike() {
        chbAddToFavourites.isEnabled = false
    }

    override fun uncheckedLike() {
        chbAddToFavourites.isChecked = false
    }

    override fun onSuccessGetCat(cat: Cat) {
        catId = cat.id
        GlideApp.with(this)
            .load(cat.url)
            .centerInside()
            .placeholder(R.drawable.ic_placeholder_cat)
            .fitCenter()
            .into(ivKitty)
    }

    override fun onSuccessAddToFavourites() {
        Toast.makeText(context, getString(R.string.success), Toast.LENGTH_LONG).show()
    }

    override fun onError() {
        Toast.makeText(context, R.string.fail, Toast.LENGTH_LONG).show()
    }
}
