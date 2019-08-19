package com.example.myapplication.presentation.views.favourites

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.presentation.adapters.FavouritesAdapter
import com.example.myapplication.presentation.presenters.FavoritesPresenter
import kotlinx.android.synthetic.main.fragment_favourites.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_favourites.srlSwipe


class FavouritesFragment : MvpAppCompatFragment(),
    FavouritesView {

    @InjectPresenter
    internal lateinit var favoritesPresenter: FavoritesPresenter

    private lateinit var favouritesAdapter: FavouritesAdapter

    companion object {
        fun newInstance(): FavouritesFragment {
            return FavouritesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFavourites.layoutManager = GridLayoutManager(context, 3)

        srlSwipe.setOnRefreshListener { favoritesPresenter.loadFavourites() }
    }

    override fun showProgressBar() {
        srlSwipe.isRefreshing = true
    }

    override fun hideProgressBar() {
        srlSwipe.isRefreshing = false
    }

    override fun onSuccessGetFavourites(cats: List<FavouriteCat>) {
        favouritesAdapter = FavouritesAdapter()
        rvFavourites.adapter = favouritesAdapter
        favouritesAdapter.setFavourites(cats)
    }

    override fun onError() {
        Toast.makeText(context, R.string.fail, Toast.LENGTH_LONG).show()
    }
}
