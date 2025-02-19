package com.fake.firstandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialise views
        val firstValue: EditText = findViewById(R.id.firstValue);
        val secondValue: EditText = findViewById(R.id.secondValue);
        val addButton: Button = findViewById(R.id.addButton);

        addButton.setOnClickListener {

            // Get input values
            val num1 = firstValue.text.toString().toDoubleOrNull();
            val num2 = secondValue.text.toString().toDoubleOrNull();

            // Check if both values are valid
            if (num1 != null && num2 != null)
            {
                // Perform addition
                val result = num1 + num2;

                // Start the new activity and pass the result
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("RESULT_VALUE", result)  // Pass the result
                startActivity(intent)  // Start ResultActivity

            }
            else
            {
                // Show error if inputs are invalid
                // Start the new activity and pass the result
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("RESULT_VALUE", "Please enter valid numbers")  // Pass the result
                startActivity(intent)  // Start ResultActivity
            }
        }


    }
}