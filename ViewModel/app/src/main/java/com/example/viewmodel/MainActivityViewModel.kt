package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var count = 0

    fun increment() {
        ++count
    }


}