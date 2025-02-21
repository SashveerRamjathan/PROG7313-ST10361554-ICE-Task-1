package com.fake.firstandroidapp

// Import necessary Android libraries
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

// Define the ProfileActivity class, which extends AppCompatActivity
class ProfileActivity : AppCompatActivity() {

    // Declare variables for UI components (ImageView & Button)
    private lateinit var ivProfilePic: ImageView  // ImageView to display the selected image
    private lateinit var btnUpload: Button  // Button to open the gallery and select an image


    private var imageUri: Uri? = null

    // Activity result launcher for selecting an image from the gallery
    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

            // If the user selects an image, update the ImageView
            uri?.let {
                ivProfilePic.setImageURI(it)  // Display the selected image
            }
        }



    // onCreate() method - Called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enables edge-to-edge UI styling
        setContentView(R.layout.activity_profile)  // Sets the layout for this activity

        // Apply window insets for proper UI alignment
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left, systemBars.top, systemBars.right, systemBars.bottom
            )
            insets
        }

        // Initialize UI components
        ivProfilePic = findViewById(R.id.iv_profilePic)  // Find ImageView by its ID
        btnUpload = findViewById(R.id.btn_upload)  // Find Button by its ID


        // Set an onClickListener on the Upload button
        btnUpload.setOnClickListener {
            pickImageFromGallery()  // Call function to open the gallery
        }


    }

    // Function to open the gallery and let the user pick an image
    private fun pickImageFromGallery() {
        pickImageLauncher.launch("image/*")  // Opens the gallery to pick an image
    }


}
