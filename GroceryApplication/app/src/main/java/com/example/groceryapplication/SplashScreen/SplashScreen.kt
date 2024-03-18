package com.example.groceryapplication.View.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.groceryapplication.R
import com.example.groceryapplication.View.Authentication.Authentication
import com.example.groceryapplication.View.Authentication.Login

class SplashScreen : AppCompatActivity() {

    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable{
            override fun run() {
                val intent = Intent(this@SplashScreen , Authentication::class.java)
                startActivity(intent)
                finish()
            }
        } , 2000)
    }
}