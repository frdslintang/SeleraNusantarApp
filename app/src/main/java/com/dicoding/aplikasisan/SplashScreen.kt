package com.dicoding.aplikasisan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghilangkan ActionBar
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 3000L) // 3000L = 3 detik
    }
}
