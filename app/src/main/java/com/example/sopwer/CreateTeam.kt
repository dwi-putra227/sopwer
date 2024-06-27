package com.example.sopwer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CreateTeam : AppCompatActivity() {

    private lateinit var nameTeam: EditText
    private lateinit var location: EditText
    private lateinit var descriptionTeam: EditText
    private lateinit var jenisOlahraga: RadioGroup
    private lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_team)

        nameTeam = findViewById(R.id.nameTeam)
        descriptionTeam = findViewById(R.id.descriptionTeam)
        location = findViewById(R.id.locationTeam)
        jenisOlahraga = findViewById(R.id.jenisOlahragaGroup)
        createButton = findViewById(R.id.create_button)

        createButton.setOnClickListener {
            val name = nameTeam.text.toString()
            val location = location.text.toString()
            val description = descriptionTeam.text.toString()
            val jenisOlahraga = getSelectedJenisOlahraga()


            if (name.isEmpty() || location.isEmpty() || description.isEmpty() || jenisOlahraga == null) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Team created successfully", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun getSelectedJenisOlahraga(): String? {
        val radioButtonId = jenisOlahraga.checkedRadioButtonId
        if (radioButtonId != -1) {
            val radioButton = findViewById<RadioButton>(radioButtonId)
            return radioButton.text.toString()
        }
        return null
    }
}