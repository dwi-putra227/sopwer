package com.example.sopwer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sopwer.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardScroll : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dashboard_scroll)

        viewPager = findViewById(R.id.viewPager)
        fragmentAdapter = FragmentAdapter(this)
        viewPager.adapter = fragmentAdapter
        viewPager.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navBar)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int){
                bottomNavigationView.selectedItemId = when (position) {
                    0 -> R.id.home
                    1 -> R.id.matchmaking
                    2 -> R.id.trophy
                    3 -> R.id.field
                    4 -> R.id.profile
                    else -> R.id.home
                }
            }
        })


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> viewPager.setCurrentItem(0, true)
                R.id.matchmaking ->viewPager.setCurrentItem(1, true)
                R.id.trophy -> viewPager.setCurrentItem(2, true)
                R.id.field-> viewPager.setCurrentItem(3, true)
                R.id.profile -> viewPager.setCurrentItem(4, true)
            }
            true
        }

        viewPager.setCurrentItem(0, true)
    }

}