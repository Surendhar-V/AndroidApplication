package com.example.finalyearproject.ViewModel

import androidx.lifecycle.ViewModel

class SignUpViewModel:ViewModel() {

    internal var emailAddress : String? = null
        get() = field
        set(value) {field = value}


}