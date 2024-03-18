package com.example.googlesignin_firebase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("685589120095-ltblm3d4bc7er399iclh71aomenbrfdf.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(applicationContext , gso)

        findViewById<Button>(R.id.GoogleSignInButton).setOnClickListener { signInGoogle() }
        findViewById<Button>(R.id.SignOutBtn_Main).setOnClickListener { signOutGoogle() }

    }

    private fun signOutGoogle(){
        auth.signOut()
        googleSignInClient.signOut().addOnCompleteListener(this) {
            Toast.makeText(this@MainActivity, "SignOut Sucessfully", Toast.LENGTH_SHORT).show()
        }
    }

    private fun  signInGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if(result.resultCode == Activity.RESULT_OK){

                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleResults(task)
                    }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if(task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if( account != null ){
                updateUI(account)
            }
        }else{
            Toast.makeText(this , "Turn On your Mobile Data" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken ,null)
        auth.signInWithCredential(credential).addOnCompleteListener {

            if(it.isSuccessful){
                val intent = Intent(this , HomeActivity::class.java)
                intent.putExtra("email" , account.email)
                intent.putExtra("name",account.displayName)
//                intent.putExtra("object" ,googleSignInClient)
                startActivity(intent)
            }else{
                Toast.makeText(this , "Turn On your Mobile Data+++" , Toast.LENGTH_SHORT).show()
            }

        }
    }
}