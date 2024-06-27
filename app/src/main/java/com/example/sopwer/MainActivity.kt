package com.example.sopwer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sopwer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.buttonLogin.setOnClickListener {
            val loginUsername = binding.editTextUsername.text.toString()
            val loginPassword = binding.editTextPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }

        binding.buttonResgister.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginDatabase(username: String, password: String){
        val userExists = db.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DashboardScroll::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}