package com.example.finalyearproject.Authentication

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
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
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.finalyearproject.R
import com.example.finalyearproject.ViewModel.LoginViewModel
import com.example.finalyearproject.ViewModel.OtpViewModel
import com.example.finalyearproject.databinding.ActivityOtpScreenBinding


class OtpScreen : AppCompatActivity() {

    private lateinit var binding: ActivityOtpScreenBinding
    private lateinit var toast: Toast
    private lateinit var otpViewModel : OtpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toast = Toast.makeText(this@OtpScreen , "Lorem Ipsum" , Toast.LENGTH_SHORT)

        otpViewModel = ViewModelProvider(this).get(OtpViewModel::class.java)
        otpViewModel.phoneNumber = intent.getStringExtra("phoneNumber")
        setKeyListners()
        setSpannableStrings()

    }

    private fun setSpannableStrings() {

        val spannable1  = SpannableString(binding.editPnOtpButton.text)
        val clickable1: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

                viewDialogBox()
            }
            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@OtpScreen, R.color.splashScreenColor)
                ds.isUnderlineText = false

                super.updateDrawState(ds)
            }
        }

        spannable1.setSpan(
            clickable1,
            0,
            binding.editPnOtpButton.text.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.editPnOtpButton.text = spannable1
        binding.editPnOtpButton.highlightColor = Color.TRANSPARENT
        binding.editPnOtpButton.movementMethod = LinkMovementMethod.getInstance()


        val spannable2  = SpannableString(binding.backLoginOtp.text)
        val clickable2 : ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                setResult(RESULT_OK , Intent().putExtra("phoneNumber",otpViewModel.phoneNumber))
                finish()
            }
            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(this@OtpScreen, R.color.splashScreenColor)
                ds.isUnderlineText = false

                super.updateDrawState(ds)
            }
        }
        spannable2.setSpan(
            clickable2,
            25,
            binding.backLoginOtp.text.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.backLoginOtp.text = spannable2
        binding.backLoginOtp.highlightColor = Color.TRANSPARENT
        binding.backLoginOtp.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun viewDialogBox(){

        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.phone_number)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val button: Button = dialog.findViewById(R.id.send_otp)
        val phoneNumber : TextView = dialog.findViewById(R.id.phone_number_ed)

        if(otpViewModel.phoneNumber != null){
            phoneNumber.text = otpViewModel.phoneNumber
        }

        button.setOnClickListener {

            if(phoneNumberCheck(phoneNumber.text.toString())) {
                toast.cancel()
                otpViewModel.phoneNumber = phoneNumber.text.toString()
                dialog.dismiss()
            }else{
                toast.cancel()
                toast = Toast.makeText(this@OtpScreen , "Enter the correct phone number" , Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        dialog.show()

    }

    fun phoneNumberCheck(phoneNumber : String) : Boolean{
        return phoneNumber.length == 10
    }

    private fun getValue(key: Int): Int {

        if (key in 7..16) {
            return key - 7
        }
        return -1

    }

    private fun setKeyListners() {

        binding.otpOne.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {

                if (event?.action == KeyEvent.ACTION_UP) {
                    return true
                }

                if (getValue(keyCode) in 0..9) {
                    binding.otpOne.setText("${getValue(keyCode)}")
                    binding.otpTwo.requestFocus()
                } else if (keyCode == 67) {
                    // Backspace
                    binding.otpOne.setText("")
                } else if (keyCode == 66) {
                    binding.otpTwo.requestFocus()
                }
                return true
            }
        })

        binding.otpTwo.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {

                if (event?.action == KeyEvent.ACTION_UP) {
                    return true
                }

                if (getValue(keyCode) in 0..9) {
                    binding.otpTwo.setText("${getValue(keyCode)}")
                    binding.otpThree.requestFocus()
                } else if (keyCode == 67) {

                    // Backspace
                    binding.otpTwo.setText("")
                    binding.otpOne.requestFocus()

                    if (binding.otpOne.text.isNotEmpty() && binding.otpOne.text.isNotBlank())
                        binding.otpOne.setSelection(1)

                } else if (keyCode == 66) {
                    binding.otpThree.requestFocus()
                }
                return true
            }
        })

        binding.otpThree.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {


                if (event?.action == KeyEvent.ACTION_UP) {
                    return true
                }


                if (getValue(keyCode) in 0..9) {
                    binding.otpThree.setText("${getValue(keyCode)}")
                    binding.otpFour.requestFocus()
                } else if (keyCode == 67) {
                    // Backspace
                    binding.otpThree.setText("")
                    binding.otpTwo.requestFocus()

                    if (binding.otpTwo.text.isNotBlank() && binding.otpTwo.text.isNotEmpty())
                        binding.otpTwo.setSelection(1)

                } else if (keyCode == 66) {
                    binding.otpFour.requestFocus()
                }
                return true
            }
        })

        binding.otpFour.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {


                if (event?.action == KeyEvent.ACTION_UP) {
                    return true
                }

                if (getValue(keyCode) in 0..9) {
                    binding.otpFour.setText("${getValue(keyCode)}")
                    binding.otpFive.requestFocus()
                } else if (keyCode == 67) {
                    binding.otpFour.setText("")
                    binding.otpThree.requestFocus()

                    if (binding.otpThree.text.isNotBlank() && binding.otpThree.text.isNotEmpty())
                        binding.otpThree.setSelection(1)

                } else if (keyCode == 66) {
                    binding.otpFive.requestFocus()
                }
                return true
            }
        })

        binding.otpFive.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {


                if (event?.action == KeyEvent.ACTION_UP) {
                    return true
                }


                if (getValue(keyCode) in 0..9) {

                    binding.otpFive.setText("${getValue(keyCode)}")
                    binding.otpFive.clearFocus()
                    val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(binding.otpFive.windowToken, 0)

                } else if (keyCode == 67) {

                    binding.otpFive.setText("")
                    binding.otpFour.requestFocus()

                    if (binding.otpFour.text.isNotBlank() && binding.otpFour.text.isNotEmpty())
                        binding.otpFour.setSelection(1)

                } else if (keyCode == 66 && checkFilled()) {
                    Toast.makeText(this@OtpScreen, "Done", Toast.LENGTH_SHORT).show()
                }

                if (checkFilled()) {
                    Toast.makeText(this@OtpScreen, "Done", Toast.LENGTH_SHORT).show()
                }

                return true
            }
        })

    }

    private fun checkFilled(): Boolean {
        var bool =
            (binding.otpOne.text.isNotEmpty() && binding.otpTwo.text.isNotEmpty() && binding.otpThree.text.isNotEmpty() && binding.otpFour.text.isNotEmpty() && binding.otpFive.text.isNotEmpty())
        bool =
            bool && (binding.otpOne.text.isNotBlank() && binding.otpTwo.text.isNotBlank() && binding.otpThree.text.isNotBlank() && binding.otpFour.text.isNotBlank() && binding.otpFive.text.isNotBlank())
        return bool
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v1 = binding.otpOne
            val v2 = binding.otpTwo
            val v3 = binding.otpThree
            val v4 = binding.otpFour
            val v5 = binding.otpFive

            val outRect1 = Rect()
            val outRect2 = Rect()
            val outRect3 = Rect()
            val outRect4 = Rect()
            val outRect5 = Rect()

            v1.getGlobalVisibleRect(outRect1)
            v2.getGlobalVisibleRect(outRect2)
            v3.getGlobalVisibleRect(outRect3)
            v4.getGlobalVisibleRect(outRect4)
            v5.getGlobalVisibleRect(outRect5)


            if (!outRect1.contains(event.rawX.toInt(), event.rawY.toInt()) &&
                !outRect2.contains(event.rawX.toInt(), event.rawY.toInt()) &&
                !outRect3.contains(event.rawX.toInt(), event.rawY.toInt()) &&
                !outRect4.contains(event.rawX.toInt(), event.rawY.toInt()) &&
                !outRect5.contains(event.rawX.toInt(), event.rawY.toInt())
            ) {
                currentFocus?.clearFocus()
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v1.windowToken, 0)
            }

        }

        return super.dispatchTouchEvent(event)
    }


}