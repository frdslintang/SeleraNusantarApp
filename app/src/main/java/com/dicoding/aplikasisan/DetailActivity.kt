package com.dicoding.aplikasisan

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.aplikasisan.databinding.ActivityDetailBinding



class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val dataFood = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>("key_food", Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>("key_food")
        }

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        tvDetailName.text = dataFood?.name
        tvDetailDescription.text = dataFood?.description
        ivDetailPhoto.setImageResource(dataFood!!.photo)

        val shareButton: Button = findViewById(R.id.action_share)
        shareButton.setOnClickListener {
            // Panggil metode untuk berbagi konten
            shareContent()
        }
    }

    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Judul berbagi") // Optional
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Halo! Ini informasi dari aplikasi Selera Asli Nusantara!"
        )
        startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))

    }
}