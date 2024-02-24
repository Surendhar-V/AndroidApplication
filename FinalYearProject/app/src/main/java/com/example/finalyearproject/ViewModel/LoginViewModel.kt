package com.example.finalyearproject.ViewModel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    internal var phoneNumber : String? = null
        get() = field
        set(value)  {field = value}

    internal var emailAddress : String? = null
        get() = field
        set(value)  {field = value}


}