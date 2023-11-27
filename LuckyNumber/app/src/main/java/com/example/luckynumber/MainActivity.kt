package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var ed_name: EditText
    lateinit var btn_nxt : Button
    lateinit var tv_msg : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_name = findViewById(R.id.ed_name)
        btn_nxt = findViewById(R.id.btn_nxt)
        tv_msg = findViewById(R.id.tv_msg)


        btn_nxt.setOnClickListener{
            btnCLick()
        }

    }

    private fun btnCLick() {

        var userName = ed_name.text.toString()

        //Explicit Intent

        val intent = Intent(this , SecondActivity::class.java)
        intent.putExtra("name" , userName)
        startActivity(intent)


    }


}