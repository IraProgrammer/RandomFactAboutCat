package com.example.myapplication.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.domain.models.FavouriteCat
import com.example.myapplication.presentation.adapters.FavouritesAdapter
import com.example.myapplication.presentation.presenters.FavoritesPresenter
import com.example.myapplication.presentation.views.FavouritesView
import kotlinx.android.synthetic.main.fragment_favourites.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.domain.models.Breed
import com.example.myapplication.presentation.adapters.BreedsAdapter
import com.example.myapplication.presentation.presenters.BreedsPresenter
import com.example.myapplication.presentation.views.BreedsView
import kotlinx.android.synthetic.main.fragment_breeds.*


class HomeFragment : MvpAppCompatFragment(), BreedsView {

    @InjectPresenter
    internal lateinit var breedsPresenter: BreedsPresenter

    private lateinit var breedsAdapter: BreedsAdapter

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_breeds, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvBreeds.layoutManager = LinearLayoutManager(context)
        breedsPresenter.loadBreeds()
    }

    override fun onSuccessGetBreeds(breed: List<Breed>) {
        breedsAdapter = BreedsAdapter()
        rvBreeds.adapter = breedsAdapter
        breedsAdapter.setBreeds(breed)
    }

    override fun onError() {
        Toast.makeText(context, "Проверьте интернет-соединение и попробуйте еще раз", Toast.LENGTH_LONG).show()
    }
}
