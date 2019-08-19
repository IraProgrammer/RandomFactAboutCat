package com.example.myapplication.presentation.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.presentation.views.breeds.BreedsFragment
import com.example.myapplication.presentation.views.favourites.FavouritesFragment
import com.example.myapplication.presentation.views.rendom_cats.RandomCatFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainBottomNavigationActivity : AppCompatActivity() {

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flContent, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(RandomCatFragment.newInstance())

        bnMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_breeds -> {
                    loadFragment(BreedsFragment.newInstance())
                }
                R.id.navigation_dashboard -> {
                    loadFragment(RandomCatFragment.newInstance())
                }
                R.id.navigation_notifications -> {
                    loadFragment(FavouritesFragment.newInstance())
                }
            }
            false
        }
    }
}
