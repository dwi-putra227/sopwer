package com.example.sopwer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TourAdapter(private val tour: List<TourData>): RecyclerView.Adapter<TourAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tourName: TextView = itemView.findViewById(R.id.nameTour)
        val dateTour: TextView = itemView.findViewById(R.id.tglTour)
        val locationTour: TextView = itemView.findViewById(R.id.lokTour)
        val contact: TextView = itemView.findViewById(R.id.kontakTour)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_tour, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tour.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tour = tour[position]
        holder.tourName.text = tour.name
        holder.dateTour.text = tour.placeDate
        holder.locationTour.text = tour.location
        holder.contact.text = tour.contact

        holder.itemView.setOnClickListener {
            when (tour.name) {
                "Tournament Kerbau Cup" -> {
                    val intent = Intent(it.context, TourDetil::class.java)
                    it.context.startActivity(intent)
                }
                else -> {
                    Toast.makeText(it.context, "No page available for ${tour.name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }


}