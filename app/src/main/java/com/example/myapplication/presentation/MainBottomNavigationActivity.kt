package com.example.myapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainBottomNavigationActivity : AppCompatActivity() {

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment.newInstance())
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
