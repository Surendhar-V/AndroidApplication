package com.example.finalyearproject.Authentication.Contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.finalyearproject.Authentication.OtpScreen


class OtpActivity : ActivityResultContract<String, String>(){
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context , OtpScreen::class.java).putExtra("phoneNumber",input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if(resultCode == Activity.RESULT_OK){
            return intent?.getStringExtra("phoneNumber")?:""
        }
        return ""
    }

}