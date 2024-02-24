package com.example.finalyearproject.Authentication.Contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import com.example.finalyearproject.Authentication.SignupScreen

class SignUpActivity : ActivityResultContract<String?, String>(){
    override fun createIntent(context: Context, input: String?): Intent {
        Log.i("TAG", "createIntent: $input")
        return Intent(context , SignupScreen::class.java).putExtra("emailAddress",input)
    }


    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if(resultCode == Activity.RESULT_OK){
            return intent?.getStringExtra("emailAddress")?:""
        }
        return ""
    }

}