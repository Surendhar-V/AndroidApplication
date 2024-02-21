package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      spinner1 = findViewById(R.id.spinner_main1)
      spinner2 = findViewById(R.id.spinner_main2)

        val arr : ArrayList<String> = ArrayList()
        arr.add("surendhar")
        arr.add("surendhar")
        arr.add("surendhar")
        arr.add("surendhar")
        arr.add("surendhar")
        arr.add("surendhar")
        arr.add("surendhar")

        val adapter1 : ArrayAdapter<String> = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item,arr)
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)
        spinner1.adapter = adapter1

        val adapter2 : ArrayAdapter<String> = ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item,arr)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2

    }
}