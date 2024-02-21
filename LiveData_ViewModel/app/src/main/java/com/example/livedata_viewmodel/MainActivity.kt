package com.example.livedata_viewmodel

import android.app.Activity
import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)



        viewModel.count.observe(this , Observer{
            binding.tv.text = it.toString()
        })

        viewModel.finished.observe(this , Observer{
            if(it){
                Toast.makeText(this , "Finished" , Toast.LENGTH_SHORT).show()
            }
        })


        binding.start.setOnClickListener {
            if (binding.editText.text.length == 0) {
                Toast.makeText(this, "Enter the text", Toast.LENGTH_SHORT).show()
            } else {
                if(viewModel.active){
                    viewModel.stopTimer()
                }

                val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.editText.windowToken, 0)

                viewModel.startValue = binding.editText.text.toString().toLong()*1000
                viewModel.startTimer()
            }
            binding.editText
        }

        binding.stop.setOnClickListener {
            binding.editText.setText("")
            binding.tv.text = "0"

            if(viewModel.active)
            viewModel.stopTimer()
        }

        binding.editText.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(v?.windowToken, 0)
            }
        })




    }

}