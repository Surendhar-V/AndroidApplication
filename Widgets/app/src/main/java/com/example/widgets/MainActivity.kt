package com.example.widgets

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.example.widgets.Spinner.Data

class MainActivity : AppCompatActivity() {

    lateinit var radioGroup : RadioGroup
    lateinit var checkBox: CheckBox
    lateinit var spinner_fruits : Spinner
    lateinit var fruitAdapter : FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox = findViewById(R.id.checkBox)
        radioGroup = findViewById(R.id.radioGroup)
        spinner_fruits = findViewById(R.id.spinner_fruit)

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                showToast("You have checked the checkbox")
            } else {
                showToast("You have unchecked the checkbox")
            }
        }

        radioGroup.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            run {
                val radioButton = findViewById<RadioButton>(i)
                Toast.makeText(
                    this,
                    "You selected ${radioButton.text.toString()}",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        fruitAdapter = FruitsAdapter(applicationContext , Data.getFruitList(applicationContext))
        spinner_fruits.adapter = fruitAdapter

        val item : String = spinner_fruits.selectedItem.toString()
        spinner_fruits.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long) {
                var s : Any? = parent?.selectedItem

                if(!(Data.array.get(s as Int).equals("--")))
                Toast.makeText(this@MainActivity , "You have selected ${Data.array.get(s as Int)}" , Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(parent: AdapterView<*>?,view: View?,position: Int,id: Long) {
                TODO("Not yet implemented")
            }


        }


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }



}
