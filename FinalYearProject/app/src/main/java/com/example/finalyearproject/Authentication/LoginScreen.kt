package com.example.finalyearproject.Authentication

import android.app.Dialog
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.finalyearproject.Authentication.Contracts.OtpActivity
import com.example.finalyearproject.Authentication.Contracts.SignUpActivity
import com.example.finalyearproject.R
import com.example.finalyearproject.ViewModel.LoginViewModel
import com.example.finalyearproject.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var loginViewModel : LoginViewModel
    private lateinit var toast : Toast


    private val OtpActivityLauncher = registerForActivityResult(OtpActivity()){
        loginViewModel.phoneNumber = it?:""
    }

    private val SignUpActivityLauncher = registerForActivityResult(SignUpActivity()){
        loginViewModel.emailAddress = it?:""
        binding.emailEdLogin.setText(loginViewModel.emailAddress?:"")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toast = Toast.makeText(this@LoginScreen , "Lorem ipsum" ,Toast.LENGTH_SHORT)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setSpannableText()

        binding.phoneSvg.setOnClickListener {PhoneNumberDialogBox()}
        binding.signInBtn.setOnClickListener { OnSignInPressed() }
        binding.forgotPasswordLogin.setOnClickListener { ForgotPasswordDialogBox() }



    }
    fun setSpannableText(){

        val spannable1 = SpannableString(binding.forgotPasswordLogin.text)
        val clickable1 : ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                ForgotPasswordDialogBox()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@LoginScreen,
                    R.color.splashScreenColor)
                super.updateDrawState(ds)
            }
        }

        spannable1.setSpan(
            clickable1,
            0,
            binding.forgotPasswordLogin.text.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.forgotPasswordLogin.text = spannable1
        binding.forgotPasswordLogin.highlightColor = Color.TRANSPARENT
        binding.forgotPasswordLogin.movementMethod = LinkMovementMethod.getInstance()



        val spannable2 = SpannableString(binding.SignUpLogin.text)
        val clickable2 : ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Log.i("TAG", "Sign up onClick: ${loginViewModel.emailAddress}")
                SignUpActivityLauncher.launch(loginViewModel.emailAddress)
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@LoginScreen,
                    R.color.splashScreenColor)
                super.updateDrawState(ds)
            }
        }

        spannable2.setSpan(
            clickable2,
            24,
            binding.SignUpLogin.text.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.SignUpLogin.text = spannable2
        binding.SignUpLogin.highlightColor = Color.TRANSPARENT
        binding.SignUpLogin.movementMethod = LinkMovementMethod.getInstance()


    }
    private fun PhoneNumberDialogBox(){

        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.phone_number)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val button: Button = dialog.findViewById(R.id.send_otp)
        val phoneNumber : TextView = dialog.findViewById(R.id.phone_number_ed)

        if(loginViewModel.phoneNumber != null){
            phoneNumber.text = loginViewModel.phoneNumber
        }

        button.setOnClickListener {

            if(phoneNumberCheck(phoneNumber.text.toString())) {
                toast.cancel()
                loginViewModel.phoneNumber = phoneNumber.text.toString()
                OtpActivityLauncher.launch(phoneNumber.text.toString())
                dialog.dismiss()
            }else{
                toast.cancel()
                toast = Toast.makeText(this@LoginScreen , "Enter the valid phone number" , Toast.LENGTH_SHORT)
                toast.show()
            }
        }

            dialog.show()

    }
    private fun ForgotPasswordDialogBox(){

        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.forgot_password)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val button: Button = dialog.findViewById(R.id.send_resetMail)
        val emailAddress : TextView = dialog.findViewById(R.id.request_emailAddress_id)

        if(loginViewModel.emailAddress != null){
            emailAddress.text = loginViewModel.emailAddress
        }

        button.setOnClickListener {

            if(emailCheck(emailAddress.text.toString())) {
                toast.cancel()
                loginViewModel.emailAddress = emailAddress.text.toString()
                toast.cancel()
                Toast.makeText(this@LoginScreen , "Check for the reset password link in your mail",Toast.LENGTH_SHORT).show()
                binding.emailEdLogin.setText(loginViewModel.emailAddress.toString())
                dialog.dismiss()
            }else{
                toast.cancel()
                toast = Toast.makeText(this@LoginScreen , "Enter the valid email address" , Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        dialog.show()

    }
    fun emailCheck(emailAddress : String) : Boolean{
        return emailAddress.contains('@')
    }
    fun OnSignInPressed(){
        loginViewModel.emailAddress = binding.emailEdLogin.text.toString()
    }
    fun phoneNumberCheck(phoneNumber:String):Boolean{
        return phoneNumber.length == 10
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