package com.example.finalyearproject.Authentication

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
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
import com.example.finalyearproject.R
import com.example.finalyearproject.ViewModel.LoginViewModel
import com.example.finalyearproject.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var viewModel : LoginViewModel
    private lateinit var toast : Toast

    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toast = Toast.makeText(this@LoginScreen , "Lorem ipsum" ,Toast.LENGTH_SHORT)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setSpannableText()

        binding.phoneSvg.setOnClickListener {viewDialogBox()}



    }

    fun setSpannableText(){

        val spannable1 = SpannableString(binding.forgotPasswordLogin.text)
        val clickable1 : ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
//                TODO() Implement the forget password here
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
            binding.ed
        )



    }

    private fun viewDialogBox(){

        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.phone_number)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val button: Button = dialog.findViewById(R.id.send_otp)
        val phoneNumber : TextView = dialog.findViewById(R.id.phone_number_ed)

        if(viewModel.phoneNumber != null){
            phoneNumber.text = viewModel.phoneNumber
        }

        button.setOnClickListener {

            if(phoneNumberCheck(phoneNumber.text.toString())) {
                toast.cancel()
                val intent = Intent(this, OtpScreen::class.java)
                viewModel.phoneNumber = phoneNumber.text.toString()
                intent.putExtra("phone number", "${phoneNumber.text}")
                startActivity(intent)
                dialog.dismiss()
            }else{
                toast.cancel()
                toast = Toast.makeText(this@LoginScreen , "Enter the correct phone number" , Toast.LENGTH_SHORT)
                toast.show()
            }
        }

            dialog.show()

    }

    fun phoneNumberCheck(phoneNumber : String) : Boolean{
        return phoneNumber.length == 10
    }

    // TODO: Change this to turn off the keyboard when touch is not in any of the fields.
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){

            if(data != null) {
                val number = data?.getStringExtra("phone number")
                viewModel.phoneNumber = number
            }
        }
    }



}