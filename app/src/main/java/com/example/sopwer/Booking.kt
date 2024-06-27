package com.example.sopwer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Booking : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FieldAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val fields = listOf<Field>(
            Field(R.drawable.basket_field, "Lekers", "Basketball", 60000, "081234567890"),
            Field(R.drawable.futsal_field, "Kang Mudryk", "Futsal", 30000, "081234567890"),
            Field(R.drawable.badminton_field, "Sukajaya", "Badminton", 30000, "081234567890"),
            Field(R.drawable.billiard_field, "One Shot Billiard", "Billiard", 50000, "018545658115")
        )

        adapter = FieldAdapter(fields)
        recyclerView.adapter = adapter


        return view

    }
}
