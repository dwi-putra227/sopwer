package com.example.sopwer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var sportList: ArrayList<Sports>
    private lateinit var sportAdapter: SportAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        sportList = ArrayList()
        recyclerView = view.findViewById(R.id.rvSport)
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        val sportList = arrayListOf(
            Sports("Basket", R.drawable.basket),
            Sports("Badminton", R.drawable.badminton),
            Sports("Billiard", R.drawable.billiard),
            Sports("Futsal", R.drawable.futsal),
            Sports("Mini Soccer", R.drawable.minsoc),
            Sports("Tennis", R.drawable.tennis)
        )

        val layoutManager = GridLayoutManager(this.requireContext(), 2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        }
        recyclerView.layoutManager = layoutManager

        sportAdapter = SportAdapter(this@Home, sportList)
        recyclerView.adapter = sportAdapter

        return view
    }

}