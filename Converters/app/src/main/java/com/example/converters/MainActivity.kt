package com.example.converters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.converters.Fragments.area
import com.example.converters.Fragments.data
import com.example.converters.Fragments.length
import com.example.converters.Fragments.mass
import com.example.converters.Fragments.speed
import com.example.converters.Fragments.temperature
import com.example.converters.Fragments.time
import com.example.converters.Fragments.volume
import com.example.converters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace( R.id.fragment, area())
            commit()
        }


        binding.btnAllClear.isEnabled = false
        setOnClickListner()

        
    }

    fun setOnClickListner(){

        binding.btnArea.setOnClickListener(this)
        binding.btnLength.setOnClickListener(this)
        binding.btnTemperature.setOnClickListener(this)
        binding.btnVolume.setOnClickListener(this)
        binding.btnMass.setOnClickListener(this)
        binding.btnData.setOnClickListener(this)
        binding.btnSpeed.setOnClickListener(this)
        binding.btnTime.setOnClickListener(this)

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)




    }

    override fun onClick(v: View?) {


        Log.i("TAG", "${v?.id}")

        val frag : Fragment? = when(v?.id){

            binding.btnArea.id -> area()
            binding.btnLength.id -> length()
            binding.btnTemperature.id -> temperature()
            binding.btnVolume.id -> volume()
            binding.btnMass.id -> mass()
            binding.btnData.id -> data()
            binding.btnSpeed.id -> speed()
            binding.btnTime.id -> time()

            else -> null
            }


        if(frag != null){
            Log.i("TAG", "onClick: ${frag.id}")
            supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment , frag)
            commit() }
            return
        }

        when(v?.id){

            binding.btn0.id -> updateText(getString(R.string.zeroText))
            binding.btn1.id -> updateText(getString(R.string.oneText))
            binding.btn2.id -> updateText(getString(R.string.twoText))
            binding.btn3.id -> updateText(getString(R.string.threeText))
            binding.btn4.id -> updateText(getString(R.string.fourText))
            binding.btn5.id -> updateText(getString(R.string.fiveText))
            binding.btn6.id -> updateText(getString(R.string.sixText))
            binding.btn7.id -> updateText(getString(R.string.sevenText))
            binding.btn8.id -> updateText(getString(R.string.eightText))
            binding.btn9.id -> updateText(getString(R.string.nineText))

            binding.btnDecimal.id -> decimal()
            binding.upArrow.id -> moveFocusUp()
            binding.downArrow.id -> moveFocusDown()



        }

    }

    fun decimal(){

    }

    fun moveFocusDown(){

    }

    fun moveFocusUp(){

    }

    private fun updateText(  s :String ){


    }


    // TODO: Make the landscape layout for the converter
    // TODO: Make the dark theme for the converter
    // TODO: Set the keypad
    // TODO: Code the rules and regulations for inputting the text
    // TODO: Converting Mechanism
    // TODO: Store the Numbers
    // TODO: Convert the String when the words are typing or when the fragment is executing
    // TODO: Delete the UNT word in the editText.text
    // TODO: Set the color for the button when pressed
    // TODO: delete the color when the button is not pressed
    // TODO: Make the hint as 0.0
    // TODO: Implement the swipe function


    // TODO( If the spinner is set to a element , then after returning the spinner should be in the same element )

}