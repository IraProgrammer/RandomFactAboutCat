package com.example.myapplication.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.widget.Toast
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


class BreedsFragment : MvpAppCompatFragment(), BreedsView {

    @InjectPresenter
    internal lateinit var breedsPresenter: BreedsPresenter

    private lateinit var breedsAdapter: BreedsAdapter

    companion object {
        fun newInstance(): BreedsFragment {
            return BreedsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_breeds, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvBreeds.layoutManager = LinearLayoutManager(context)

        srlSwipe.setOnRefreshListener { breedsPresenter.loadBreeds() }
    }

    override fun showProgressBar(){
        srlSwipe.isRefreshing = true
    }

    override fun hideProgressBar(){
        srlSwipe.isRefreshing = false
    }

    override fun onSuccessGetBreeds(breed: List<Breed>) {
        breedsAdapter = BreedsAdapter()
        rvBreeds.adapter = breedsAdapter
        breedsAdapter.setBreeds(breed)
    }

    override fun onError() {
        Toast.makeText(context, getString(R.string.fail), Toast.LENGTH_LONG).show()
    }
}
