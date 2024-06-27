package com.example.sopwer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SportAdapter(private val getActivity: Home, private val sportList: List<Sports>) : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_olahraga, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sportTitle.text = sportList[position].title
        holder.sportImg.setImageResource(sportList[position].image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val sportTitle : TextView = itemView.findViewById(R.id.sportTitle)
        val sportImg : ImageView = itemView.findViewById(R.id.imgSport)
    }

}