package com.example.finalyearproject.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.finalyearproject.Authentication.LoginScreen
import com.example.finalyearproject.MainActivity
import com.example.finalyearproject.R

class SplashScreen : AppCompatActivity() {

    private lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable{
            override fun run() {
                val intent = Intent(this@SplashScreen ,LoginScreen::class.java)
                startActivity(intent)
                finish()
            }

        }, 2000)
    }
}