package com.example.centimetertometer

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var tv_unitConverstion: TextView
    lateinit var tv_cm2m : TextView
    lateinit var m_unit : TextView
    lateinit var ed_cm : EditText
    lateinit var btn_convert : Button
    lateinit var tv_meter : TextView
    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_unitConverstion = findViewById(R.id.tv_unitConversion)
        tv_cm2m = findViewById(R.id.tv_cm2m)
        m_unit = findViewById(R.id.m)
        ed_cm = findViewById(R.id.et_cm)
        btn_convert = findViewById(R.id.btn)
        tv_meter = findViewById(R.id.tv_meter)
        layout = findViewById(R.id.layout)


        tv_unitConverstion.setText("Unit Convertion")
        tv_cm2m.setText("cm to m")
        m_unit.setText("m")
        tv_meter.setText("0.0")
        ed_cm.hint = "Enter the number"

         var toast : Toast = Toast.makeText(applicationContext , "Enter the valid number" , Toast.LENGTH_SHORT)

        layout.setOnClickListener( View.OnClickListener {  toast.cancel()} )

        ed_cm.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                val textLength = ed_cm.text.toString().length
                val newWidth = textLength * 50
                ed_cm.width = newWidth
                ed_cm.hint = ""
            }

        })

        btn_convert.setOnClickListener(View.OnClickListener {

            val cm = ed_cm.text.toString()
            if(!containsLetter(cm)){
                cm.trim()
                val meter : Double =  convert(cm.toDoubleOrNull())
                tv_meter.setText(meter.toString())
            }else{

               toast.show()
                tv_meter.setText("0.0")
            }


        })



    }


    private fun containsLetter(s :String):Boolean{

        for(i in s){
            if((i >= 'A' && i<='Z') ||(i>='a' && i<='z')){
              return true
            }
        }

        return false
    }
    private fun convert(value : Double?) : Double{

        var value1:Double? = value

        value1 = value1?:0.0
        val meter = value1/100.0

        return meter
    }


}