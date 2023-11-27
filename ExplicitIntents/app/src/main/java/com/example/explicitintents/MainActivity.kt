package com.example.explicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btn_google:Button
    lateinit var btn_email: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_email =  findViewById(R.id.btn_email)
        btn_google = findViewById(R.id.btn_google)


        btn_google.setOnClickListener {openWebPage()}
        btn_email.setOnClickListener {openEmail()}


    }

    private fun openEmail(){

        val intent = Intent(Intent.ACTION_SEND).apply {
                     type = "text/plain"
                     putExtra(Intent.EXTRA_EMAIL , arrayOf("v.surendharsuren@gmail.com"))
                     putExtra(Intent.EXTRA_SUBJECT , "This is the subject of the email")
                     putExtra(Intent.EXTRA_TEXT , "This app is awesome")
                    }

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "You have no application for Email" , Toast.LENGTH_SHORT)
        }

    }

    private fun openWebPage() {

        val webpage : Uri = Uri.parse("http://www.google.com")

        val intent =   Intent(Intent.ACTION_VIEW)
        intent.setData(webpage)
        intent.setPackage("com.android.chrome")
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{

            Toast.makeText(this, "You have no Chrome " , Toast.LENGTH_SHORT)


        }

        }

}