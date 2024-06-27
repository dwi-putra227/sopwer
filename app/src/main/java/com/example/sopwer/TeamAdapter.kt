package com.example.sopwer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(private val team: List<Team>)  : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>(){
    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val teamName: TextView = itemView.findViewById(R.id.team_name)
        val sportName: TextView = itemView.findViewById(R.id.sport_name)
        val location: TextView = itemView.findViewById(R.id.location)
        val maxMembers: TextView = itemView.findViewById(R.id.max_members)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return team.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = team[position]
        holder.teamName.text = team.name
        holder.sportName.text = team.sportName
        holder.location.text = team.location
        holder.maxMembers.text = "Max Members: ${team.maxMembers}"
    }
}