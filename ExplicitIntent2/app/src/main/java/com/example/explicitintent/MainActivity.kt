package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btn_secondActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_secondActivity = findViewById(R.id.btn_SecondActivity)
        btn_secondActivity.setOnClickListener { moveActivity()}

    }

    private fun moveActivity() {
        val intent = Intent(this , SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext ,"OnStop function in Main Activity is  called" , Toast.LENGTH_SHORT ).show()
    }

}