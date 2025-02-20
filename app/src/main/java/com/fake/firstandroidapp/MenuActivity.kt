package com.fake.firstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    lateinit var btnStartCalc: Button
    lateinit var btnComingSoon: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        btnStartCalc = findViewById(R.id.start_calc)
        btnComingSoon = findViewById(R.id.btn_coming_soon)

        btnStartCalc.setOnClickListener {

            // Handle button click
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        btnComingSoon.setOnClickListener {

            Toast.makeText(this, "Feature coming soon!", Toast.LENGTH_SHORT).show()
        }

    }
}