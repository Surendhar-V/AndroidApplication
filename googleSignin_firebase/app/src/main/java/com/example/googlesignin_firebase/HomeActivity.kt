package com.example.googlesignin_firebase

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class HomeActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<TextView>(R.id.email_text).setText(intent.getStringExtra("email"))

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("685589120095-ltblm3d4bc7er399iclh71aomenbrfdf.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this , gso)



        findViewById<Button>(R.id.SignoutBtn).setOnClickListener {
            signOut()
        }


        findViewById<Button>(R.id.GoBackBtn).setOnClickListener {

        }

    }

    private fun signOut(){
        auth.signOut()


        findViewById<TextView>(R.id.email_text).setText("")
    }



    private fun returnBack(){
        finish()
    }
}