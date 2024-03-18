package com.example.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    lateinit var count : MutableLiveData<String>

    fun initCount(){
        this.count = MutableLiveData()
        count.value = "0"
    }
    fun increment(){
        count.value = (count.value?:"0").toInt().plus(1).toString()
    }

}