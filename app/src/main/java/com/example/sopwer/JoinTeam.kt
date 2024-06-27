package com.example.sopwer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JoinTeam : AppCompatActivity() {

    private lateinit var teamList: RecyclerView
    private lateinit var adapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_team)


        teamList = findViewById(R.id.team_list)
        teamList.layoutManager = LinearLayoutManager(this)

        val teams = listOf(
            Team(1, "Team A", "Football", "New York", 10),
            Team(2, "Team B", "Basketball", "Los Angeles", 12),
            Team(3, "Team C", "Soccer", "Chicago", 15),
            Team(4, "Team D", "Tennis", "Miami", 8),
            Team(5, "Team E", "Volleyball", "San Francisco", 11)
        )

        adapter = TeamAdapter(teams)
        teamList.adapter = adapter
    }
}