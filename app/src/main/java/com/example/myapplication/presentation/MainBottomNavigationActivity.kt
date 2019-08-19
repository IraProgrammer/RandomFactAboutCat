package com.example.myapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainBottomNavigationActivity : AppCompatActivity() {

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flContent, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(BreedsFragment.newInstance())

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
