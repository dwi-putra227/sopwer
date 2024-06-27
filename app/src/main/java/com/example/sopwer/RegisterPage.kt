package com.example.sopwer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopwer.databinding.ActivityMainBinding
import com.example.sopwer.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPageBinding
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.btnRegister.setOnClickListener {
            val registerUsername = binding.usernameRegister.text.toString()
            val registerPassword = binding.passwordRegister.text.toString()
            registerDatabase(registerUsername, registerPassword)
        }

        binding.btnLoginRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerDatabase(username: String, password: String){
        val insertedRowId = db.insertUser(username, password)
        if (insertedRowId != -1L){
            Toast.makeText(this, "Signup Successfull", Toast.LENGTH_SHORT).show()
            val sharedPreferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("USERNAME", username)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
        }
    }

}