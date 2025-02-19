package com.fake.firstandroidapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // Retrieve the result from Intent
        val result = intent.getDoubleExtra("RESULT_VALUE", 0.0)

        // Get reference to the TextView
        val resultText: TextView = findViewById(R.id.resultTextView)

        // Display the result
        resultText.text = "Result: $result"
    }
}