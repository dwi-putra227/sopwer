package com.example.sopwer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(activity : FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 5;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Home();
            1 -> Matchmaking();
            2 -> Tournament();
            3 -> Booking();
            4 -> Profile();
            else -> Home();
        }
    }
}