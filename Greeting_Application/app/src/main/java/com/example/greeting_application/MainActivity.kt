package com.example.greeting_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var layout : ConstraintLayout
    lateinit var tv_msg : TextView
    lateinit var ed_name : EditText
    lateinit var btn_submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_msg = findViewById(R.id.tv_msg)
        ed_name = findViewById(R.id.et_name)
        btn_submit = findViewById(R.id.btn_submit)
        layout = findViewById(R.id.container)


        tv_msg.setText("Enter your Name")

        var name : String = ed_name.text.toString()
        lateinit var toast : Toast

        layout.setOnClickListener {

            toast.cancel()

        }

        btn_submit.setOnClickListener {

            name= ed_name.text.toString()
            toast = Toast.makeText(applicationContext ,"Hello $name" , Toast.LENGTH_SHORT)
            toast?.show()

        }



    }




}