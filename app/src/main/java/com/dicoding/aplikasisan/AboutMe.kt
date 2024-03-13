package com.dicoding.aplikasisan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val fullNameTextView = findViewById<TextView>(R.id.full_name3)
        val emailTextView = findViewById<TextView>(R.id.email)
        val profileImageView = findViewById<ImageView>(R.id.profile_image)

        fullNameTextView.text = "Lintang Firdaus"
        emailTextView.text = "a296bsx2162@bangkit.academy"

        // Set gambar profil (pastikan Anda sudah mengatur gambar profil dengan bentuk bulat)
        profileImageView.setImageResource(R.drawable.me)
    }
}
