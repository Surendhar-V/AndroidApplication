package com.example.listviewarrayadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var  listView : ListView
    private val list : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")
        list.add("Surendhar")

        listView = findViewById(R.id.listView)

        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter


    }
}