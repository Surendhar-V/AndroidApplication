package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "OnCreate() is called" , Toast.LENGTH_SHORT ).show()
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "OnStart() is called" , Toast.LENGTH_SHORT ).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "OnResume() is called" , Toast.LENGTH_SHORT ).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext , "OnRestart() is called" , Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
            Log.i("Main Activity" , "OnStop is called")
        //Releases resources , save data , etc...
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "OnDestroy() is called" , Toast.LENGTH_SHORT ).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "OnPause() is called" , Toast.LENGTH_SHORT ).show()
    }


}