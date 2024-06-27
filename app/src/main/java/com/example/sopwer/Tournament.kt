package com.example.sopwer

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tournament : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TourAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tournament, container, false)

        recyclerView = view.findViewById(R.id.rvTour)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val tour = listOf<TourData>(
            TourData("Tournament Kerbau Cup", "2023-02-20", "Jakarta", "081234567890"),
            TourData("Fifa Kabupaten Cup", "2023-03-15, Bandung", "Bandung", "081234567890"),
            TourData("BWF Bojongsoang Championships", "2023-02-20, Jakarta", "Jakarta", "081234567890"),
            TourData("Tour 2", "2023-03-15, Bandung", "Bandung", "081234567890"),
            TourData("Tour 1", "2023-02-20, Jakarta", "Jakarta", "081234567890"),
            TourData("Tour 2", "2023-03-15, Bandung", "Bandung", "081234567890")
        )

        recyclerView.addItemDecoration(SpaceItemDecoration(8))
        adapter = TourAdapter(tour)
        recyclerView.adapter = adapter
        return view
    }
    class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = space
        }
    }
}
