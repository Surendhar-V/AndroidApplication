package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var fab : FloatingActionButton
    lateinit var tv_msg : TextView
    lateinit var tv_counter : TextView
    lateinit var btn_reset : Button

    companion object{

        var counter : Int = 0

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_reset = findViewById(R.id.btn_reset)
        fab = findViewById(R.id.fab_inc)
        tv_msg = findViewById(R.id.tv_Msg)
        tv_counter = findViewById(R.id.tv_counter)
        tv_msg.setText("Press the button for increasing or decreasing the counter")
        tv_counter.setText(counter.toString())

        fab.setOnClickListener(View.OnClickListener {
            counter++
            tv_counter.setText(counter.toString())
        })

        btn_reset.setOnClickListener(View.OnClickListener() {

            counter = 0
            tv_counter.setText(counter.toString())

        })




    }
}