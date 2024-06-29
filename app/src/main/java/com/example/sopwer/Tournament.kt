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
            TourData(R.drawable.tour,"Tournament Kerbau Cup", "2023-02-20", "Jakarta", "2600000","081234567890"),
            TourData(R.drawable.tour,"Fifa Kabupaten Cup", "2023-03-15", "Bandung", "1600000","081234567235"),
            TourData(R.drawable.tour,"BWF Bojongsoang Championships", "2023-02-20", "Jakarta","2000000", "081234527890"),
            TourData(R.drawable.tour,"Ace Camphionship", "2023-03-15", "Bandung", "10000000","081234567231"),
            TourData(R.drawable.tour,"League 1", "2023-02-20", "Jakarta", "2200000","081234135135"),
            TourData(R.drawable.tour,"Shot One Tournament", "2024-03-15", "Bandung", "6000000","0812345135890")
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
