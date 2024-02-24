package com.example.finalyearproject.Authentication

import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.finalyearproject.R
import com.example.finalyearproject.ViewModel.SignUpViewModel
import com.example.finalyearproject.databinding.ActivitySignupScreenBinding

class SignupScreen : AppCompatActivity() {
    
    private lateinit var binding : ActivitySignupScreenBinding 
    private lateinit var signUpViewModel : SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        signUpViewModel.emailAddress = intent.getStringExtra("emailAddress")?:""
        binding.signUpBtn.setOnClickListener { signInUser() }
        setSpannableText()

        binding.emailSignUpEd.setText(signUpViewModel.emailAddress)

    }

    private fun signInUser(){
        signUpViewModel.emailAddress = binding.emailSignUpEd.text.toString()
    }
    
    private fun setSpannableText(){

        val spannable1  = SpannableString(binding.loginSignUp.text)
        val clickable1: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

                setResult(RESULT_OK , Intent().putExtra("emailAddress",signUpViewModel.emailAddress))
                finish()

            }
            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@SignupScreen, R.color.splashScreenColor)
                ds.isUnderlineText = false

                super.updateDrawState(ds)
            }
        }
        spannable1.setSpan(
            clickable1,
            25,
            binding.loginSignUp.text.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.loginSignUp.text = spannable1
        binding.loginSignUp.highlightColor = Color.TRANSPARENT
        binding.loginSignUp.movementMethod = LinkMovementMethod.getInstance()
        
    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }


}