package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        var countries : Array<String> = arrayOf("USA" , "Germany" , "Saudi Arabia" , "France","India","Nepal" , "Japan" , "Sri Lanka" , "Bhutan" , "Burma" , "Pakistan" , "Iran" , "Iraq")

        val adapter : MyCustomAdapter = MyCustomAdapter(this , countries)

        listView.adapter = adapter


    }
}