package com.example.sopwer

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private lateinit var sharedPreferences: SharedPreferences

class Profile : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = context.getSharedPreferences("USER_PREFS", MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val username = sharedPreferences.getString("USERNAME", "")
        val usernameTextView = view.findViewById<TextView>(R.id.usernameTextView)
        usernameTextView.text = "Username: $username"

        val email = sharedPreferences.getString("EMAIL", "")
        val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
        emailTextView.text = "Email: $email"

        val joinTeamButton = view.findViewById<Button>(R.id.joinTeam)
        joinTeamButton.setOnClickListener {
            val intent = Intent(activity, JoinTeam::class.java)
            startActivity(intent)
        }

        val createTeamButton = view.findViewById<Button>(R.id.createTeam)
        createTeamButton.setOnClickListener {
            val intent = Intent(activity, CreateTeam::class.java)
            startActivity(intent)
        }

        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}