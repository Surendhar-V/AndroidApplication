package com.example.livedata_viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel() : ViewModel() {

   var startValue : Long  = 10000
   private lateinit var timer: CountDownTimer
   val count = MutableLiveData<Int>()
   var finished = MutableLiveData<Boolean>()
   var active : Boolean = false

   fun startTimer(){
       timer = object : CountDownTimer(startValue ,1000){
           override fun onTick(millisUntilFinished: Long) {
               active = true
               count.value = (millisUntilFinished/1000).toInt()
           }

           override fun onFinish() {
               finished.value = true
           }

       }.start()
   }

    fun stopTimer(){
        active = false
        timer.cancel()
    }

}