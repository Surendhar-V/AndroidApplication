package com.example.calculator

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, SensorEventListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toast: Toast
    private var TAG: String = "TAG"
    private var isNightMode: Boolean = false

    private var one : Boolean = false
    private var two : Boolean = false

    private lateinit var sensorManager: SensorManager


    private var runnableString: String = "Its working"
    private val orientationHandler = Handler(Looper.getMainLooper())
    private val orientationRunnable = object : Runnable {
        override fun run() {
            Log.i("TAG", "${runnableString}")
            orientationHandler.postDelayed(this, 500)
        }
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this )
        orientationHandler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        one = false
        two = false

        toast = Toast.makeText(applicationContext, "Calculator", Toast.LENGTH_SHORT)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_NORMAL,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }

        orientationHandler.post(orientationRunnable)

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

        binding.btnAC.setOnClickListener(this)
        binding.btnBracket.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)
        binding.btnDecimalpoint.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)
        binding.btnEqual.setOnClickListener(this)
        binding.btnMinus.setOnClickListener(this)
        binding.btnModulus.setOnClickListener(this)
        binding.btnMultiply.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
        binding.btnback.setOnClickListener(this)
        binding.constraintLayer.setOnClickListener(this)
        binding.btnTheme.setOnClickListener(this)
        binding.btnCalcMode.setOnClickListener(this)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            isNightMode = false
            binding.btnTheme.setImageResource(R.drawable.blue_bulb)
        } else if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            isNightMode = true
            binding.btnTheme.setImageResource(R.drawable.gray_bulb)
        } else {
            isNightMode = false
            binding.btnTheme.setImageResource(R.drawable.blue_bulb)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        binding.edEq.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (binding.edEq.text.length == 14) {
                        binding.edEq.textSize = 30.0f
                    } else if (binding.edEq.text.length < 14) {
                        binding.edEq.textSize = 40.0f
                    }
                }
            }

        })

    }


    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {

                binding.btn0.id -> numbers(getString(R.string.zeroText))
                binding.btn1.id -> numbers(getString(R.string.oneText))
                binding.btn2.id -> numbers(getString(R.string.twoText))
                binding.btn3.id -> numbers(getString(R.string.threeText))
                binding.btn4.id -> numbers(getString(R.string.fourText))
                binding.btn5.id -> numbers(getString(R.string.fiveText))
                binding.btn6.id -> numbers(getString(R.string.sixText))
                binding.btn7.id -> numbers(getString(R.string.sevenText))
                binding.btn8.id -> numbers(getString(R.string.eightText))
                binding.btn9.id -> numbers(getString(R.string.nineText))

                binding.btnClear.id -> clear()
                binding.btnback.id -> backSpace()
                binding.btnAC.id -> allClear()
                binding.btnBracket.id -> bracket()
                binding.btnDecimalpoint.id -> operators(getString(R.string.decimalText))
                binding.btnDivide.id -> operators(getString(R.string.divideText))
                binding.btnEqual.id -> equal()
                binding.btnMinus.id -> operators(getString(R.string.subtractText))
                binding.btnModulus.id -> operators(getString(R.string.moduloText))
                binding.btnMultiply.id -> operators(getString(R.string.multiplyText))
                binding.btnPlus.id -> operators(getString(R.string.addText))
                binding.constraintLayer.id -> toastCancel()
                binding.btnEqual.id -> performCalculation()
                binding.btnTheme.id -> changeTheme()
                binding.btnCalcMode.id -> changeOrientation()

            }
        }

    }

    private fun changeOrientation() {

        val currentOrientation = resources.configuration.orientation

        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            two = true
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            one = true
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }

    }

    override fun onRestoreInstanceState( savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        one = savedInstanceState.getBoolean("one")
        two = savedInstanceState.getBoolean("two")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("one" , one)
        outState.putBoolean("two" , two)
    }




    private fun changeTheme() {

        if (isNightMode) {
            isNightMode = false
            binding.btnTheme.setImageResource(R.drawable.blue_bulb)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            isNightMode = true
            binding.btnTheme.setImageResource(R.drawable.gray_bulb)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

    }

    private fun performCalculation() {

    }

    private fun toastCancel() {
        toast.cancel()
    }

    private fun allClear() {
        toast.cancel()
        binding.tvRes.text = ""
        binding.edEq.setText("")
        binding.edEq.textSize = 35.0f
    }

    private fun isBalanced(s: String, pos: Int): Int {

        var stack: ArrayDeque<Char> = ArrayDeque()

        for (i in 0 until pos) {

            if (!stack.isEmpty() && s.get(i) == ')' && stack.get(stack.size - 1) == '(') {
                stack.removeLast()
            } else if (s.get(i) == ')' || s.get(i) == '(') {
                stack.addLast(s.get(i))
            }

        }

        return stack.size
    }

    private fun equal() {

        toast.cancel()
        binding.tvRes.text = "Lorem ipsum"


        var open_bracket_count =
            isBalanced(binding.edEq.text.toString(), binding.edEq.selectionStart)

        var s: String = binding.edEq.text.toString()
        if (s.length != 0 && ((s.get(s.length - 1)
                .equals(getString(R.string.addText))) || (s.get(s.length - 1)
                .equals(getString(R.string.subtractText))) || (s.get(s.length - 1)
                .equals(getString(R.string.multiplyText))) || (s.get(s.length - 1)
                .equals(getString(R.string.divideText))) || (s.get(s.length - 1)
                .equals(getString(R.string.moduloText))))
        ) {

            toast.cancel()
            toast = Toast.makeText(applicationContext, "Invalid Equation", Toast.LENGTH_SHORT)
            toast.show()
            return

        }

        if (s.length != 0 && s.get(s.length - 1).equals(getString(R.string.decimalText))) {

            s = s + getString(R.string.zeroText)

        }

        if (open_bracket_count != 0) {
            for (i in 0 until open_bracket_count) {
                s += getString(R.string.closed_parentheses)
            }
        }

        // TODO("Pre Processing for the decimal point")


    }

    private fun backSpace() {

//        TODO("selection and back space facility")
//        TODO("Long press on back space")

        if (binding.edEq.text.length == 1) {
            clear()
            return
        }

        val cursorpos: Int = binding.edEq.selectionStart

        if (cursorpos != 0 && binding.edEq.text.length != 0) {

            var left: String = binding.edEq.text.substring(0, binding.edEq.selectionStart)
            var right: String = binding.edEq.text.substring(binding.edEq.selectionStart)
            left = left.substring(0, left.length - 1)
            binding.edEq.setText(String.format("%s%s", left, right))
            binding.edEq.setSelection(cursorpos - 1)

        } else {
            toast.cancel()
            toast =
                Toast.makeText(applicationContext, "Empty Equation detected", Toast.LENGTH_SHORT)
            toast.show()
        }

    }

    private fun clear() {

        toast.cancel()
        binding.edEq.setText("")
        binding.edEq.setSelection(0)

    }

    private fun bracket() {

        var close_bracket_bool: Boolean =
            isBalanced(binding.edEq.text.toString(), binding.edEq.selectionStart) != 0


        var lastString: String

        if (binding.edEq.selectionStart == 0) {
            updateText(getString(R.string.open_parentheses))
            Log.i(TAG, "bracket: stage 11 crossed")
            return
        } else {
            Log.i(TAG, "bracket: stage 12 crossed")
            lastString =
                binding.edEq.text.toString().get(binding.edEq.selectionStart - 1).toString()
        }


        if (binding.edEq.selectionStart != binding.edEq.text.length) {

            lastString =
                binding.edEq.text.toString().get(binding.edEq.selectionStart - 1).toString()
            Log.i(TAG, "bracket: stage 13 crossed")
            if (close_bracket_bool) {
                // Not balanced
                Log.i(TAG, "bracket: stage 14 crossed")
                // If lastString == digit
                if ((!lastString.equals(getString(R.string.multiplyText)) && !lastString.equals(
                        getString(R.string.divideText)
                    ) && !lastString.equals(getString(R.string.addText)) && !lastString.equals(
                        getString(R.string.subtractText)
                    ) && !lastString.equals(getString(R.string.moduloText)) && !lastString.equals(
                        getString(R.string.decimalText)
                    ) && !lastString.equals(getString(R.string.open_parentheses))) || lastString.equals(
                        getString(R.string.closed_parentheses)
                    )
                ) {
                    Log.i(TAG, "bracket: stage 15 crossed")
                    updateText(getString(R.string.closed_parentheses))
                    var string =
                        binding.edEq.text.toString().get(binding.edEq.selectionStart).toString()
                    Log.i(TAG, "bracket: right String => ${string}")
                    if (!string.equals(getString(R.string.addText)) || !string.equals(getString(R.string.subtractText)) || !string.equals(
                            getString(R.string.multiplyText)
                        ) || !string.equals(getString(R.string.divideText)) || !string.equals(
                            getString(R.string.moduloText)
                        ) || !string.equals(getString(R.string.decimalText))
                    ) {
                        updateText(getString(R.string.multiplyText))
                    }
                } else if (lastString.equals(getString(R.string.decimalText))) {
                    Log.i(TAG, "bracket: stage 16 crossed")
                    updateText(getString(R.string.zeroText))
                    updateText(getString(R.string.closed_parentheses))

                    var string =
                        binding.edEq.text.toString().get(binding.edEq.selectionStart).toString()
                    Log.i(TAG, "bracket: right String => ${string}")

                    if (!string.equals(getString(R.string.addText)) || !string.equals(getString(R.string.subtractText)) || !string.equals(
                            getString(R.string.multiplyText)
                        ) || !string.equals(getString(R.string.divideText)) || !string.equals(
                            getString(R.string.moduloText)
                        ) || !string.equals(getString(R.string.decimalText))
                    ) {
                        updateText(getString(R.string.multiplyText))
                    }

                } else {
                    Log.i(TAG, "bracket: stage 17 crossed")
                    updateText(getString(R.string.open_parentheses))
                }
            } else {
                // balanced
                Log.i(TAG, "bracket: stage 18 crossed")
                if (!lastString.equals(getString(R.string.multiplyText)) && !lastString.equals(
                        getString(R.string.divideText)
                    ) && !lastString.equals(getString(R.string.addText)) && !lastString.equals(
                        getString(R.string.subtractText)
                    ) && !lastString.equals(getString(R.string.moduloText)) && !lastString.equals(
                        getString(R.string.decimalText)
                    )
                ) {
                    Log.i(TAG, "bracket: stage 19 crossed")
                    updateText(getString(R.string.multiplyText))
                    updateText(getString(R.string.open_parentheses))
                } else if (lastString.equals(getString(R.string.decimalText))) {
                    Log.i(TAG, "bracket: stage 21 crossed")
                    updateText(getString(R.string.zeroText))
                    updateText(getString(R.string.closed_parentheses))

                    var string =
                        binding.edEq.text.toString().get(binding.edEq.selectionStart).toString()
                    if (string.equals(getString(R.string.addText)) || string.equals(getString(R.string.subtractText)) || string.equals(
                            getString(R.string.multiplyText)
                        ) || string.equals(getString(R.string.divideText)) || string.equals(
                            getString(R.string.moduloText)
                        ) || string.equals(getString(R.string.decimalText))
                    ) {
                        updateText(getString(R.string.multiplyText))
                    }

                } else {
                    Log.i(TAG, "bracket: stage 22 crossed")
                    updateText(getString(R.string.open_parentheses))
                }

            }
            return
        }


        // . => .0*(
        if (lastString.equals(getString(R.string.decimalText))) {
            updateText(getString(R.string.zeroText))
            updateText(getString(R.string.multiplyText))
            updateText(getString(R.string.open_parentheses))
            Log.i(TAG, "bracket: stage 22 crossed")
            return
        }


        if (!close_bracket_bool && (lastString.equals(getString(R.string.closed_parentheses)) || lastString.equals(
                getString(R.string.decimalText)
            ) || (!lastString.equals(getString(R.string.addText)) && !lastString.equals(getString(R.string.subtractText)) && !lastString.equals(
                getString(R.string.multiplyText)
            ) && !lastString.equals(getString(R.string.divideText)) && !lastString.equals(
                getString(
                    R.string.moduloText
                )
            )))
        ) {
            Log.i(TAG, "bracket: stage 23 crossed")
            if (lastString.equals(getString(R.string.decimalText))) {
                updateText(getString(R.string.zeroText))
            }
            updateText(getString(R.string.multiplyText))
            updateText(getString(R.string.open_parentheses))
        } else if (!close_bracket_bool) {
            Log.i(TAG, "bracket: stage 24 crossed")
            updateText(getString(R.string.open_parentheses))
        } else {

            if (lastString.equals(getString(R.string.addText)) || lastString.equals(getString(R.string.subtractText)) || lastString.equals(
                    getString(R.string.multiplyText)
                ) || lastString.equals(getString(R.string.divideText)) || lastString.equals(
                    getString(R.string.moduloText)
                )
            ) {
                Log.i(TAG, "bracket: stage 26 crossed")
                updateText(getString(R.string.open_parentheses))
                return
            } else if (!lastString.equals(getString(R.string.open_parentheses))) {
                Log.i(TAG, "bracket: stage 25 crossed")
                updateText(getString(R.string.closed_parentheses))
                return
            } else {
                // There is the open bracket
                Log.i(TAG, "bracket: stage 27 crossed")
                updateText(getString(R.string.open_parentheses))
            }

        }


    }

    private fun operators(strToAdd: String) {

        var lastString: String


        if (binding.edEq.text.length != 0) {
            lastString =
                binding.edEq.text.toString().get(binding.edEq.selectionStart - 1).toString()
        } else {
            lastString = ""
        }

        // text length is not equal to zero , but the selection is at the initial position
        if (binding.edEq.selectionStart == 0 && !strToAdd.equals(getString(R.string.decimalText))) {
            toast.cancel()
            toast = Toast.makeText(applicationContext, "Invalid Equation", Toast.LENGTH_SHORT)
            toast.show()
            Log.i(TAG, "operators: stage 2 crossed")

            return
        }


//       TODO(". => 0. // If there is no digit in the front of the dot")
//       TODO("No Dot in the same number set")

        //          (+   =>     NO
        if (binding.edEq.text.length != 0 && lastString.equals(getString(R.string.open_parentheses)) && (strToAdd.equals(
                getString(R.string.divideText)
            ) || strToAdd.equals(getString(R.string.multiplyText)) || strToAdd.equals(getString(R.string.addText)) || strToAdd.equals(
                getString(R.string.subtractText)
            ) || strToAdd.equals(getString(R.string.moduloText)))
        ) {

            toast.cancel()
            toast = Toast.makeText(applicationContext, "Invalid Equation", Toast.LENGTH_SHORT)
            toast.show()
            Log.i(TAG, "operators: stage 3 crossed")
            return

        }


        // At the starting . => 0.
        if (strToAdd.equals(getString(R.string.decimalText)) && binding.edEq.text.length == 0) {
            updateText("${getString(R.string.zeroText)}")
            updateText("${getString(R.string.decimalText)}")
            Log.i(TAG, "operators: stage 4 crossed")
            return
        }

        // +. => +0.
        if (strToAdd.equals(getString(R.string.decimalText)) && (lastString.equals(getString(R.string.addText)) || lastString.equals(
                getString(R.string.subtractText)
            ) || lastString.equals(getString(R.string.divideText)) || lastString.equals(getString(R.string.moduloText)) || lastString.equals(
                getString(R.string.multiplyText)
            ))
        ) {
            updateText("${getString(R.string.zeroText)}")
            updateText("${getString(R.string.decimalText)}")
            Log.i(TAG, "operators: stage 5 crossed")

            return
        }

        //  .+ => .0+
        if (lastString.equals(getString(R.string.decimalText)) && (strToAdd.equals(getString(R.string.multiplyText)) || strToAdd.equals(
                getString(R.string.moduloText)
            ) || strToAdd.equals(getString(R.string.divideText)) || strToAdd.equals(getString(R.string.subtractText)) || strToAdd.equals(
                getString(R.string.addText)
            ))
        ) {
            updateText(getString(R.string.zeroText))
            updateText(strToAdd)
            Log.i(TAG, "operators: stage 6 crossed")

            return
        }

        // NO TWO CONSECUTIVE OPERATORS
        if (strToAdd.equals(getString(R.string.divideText)) || strToAdd.equals(getString(R.string.multiplyText)) || strToAdd.equals(
                getString(R.string.addText)
            ) || strToAdd.equals(getString(R.string.subtractText)) || strToAdd.equals(getString(R.string.moduloText)) || strToAdd.equals(
                getString(R.string.closed_parentheses)
            ) || strToAdd.equals(getString(R.string.decimalText))
        ) {
            Log.i(TAG, "operators: stage 7 crossed")


            if (binding.edEq.text.length != 0 && lastString.equals(getString(R.string.divideText)) || lastString.equals(
                    getString(R.string.multiplyText)
                ) || lastString.equals(getString(R.string.addText)) || lastString.equals(getString(R.string.subtractText)) || lastString.equals(
                    getString(R.string.moduloText)
                ) || lastString.equals(getString(R.string.decimalText))
            ) {

                backSpace()
                updateText(strToAdd)
                Log.i(TAG, "operators: stage 8 crossed")
                return
            } else {
                Log.i(TAG, "operators: stage 10 crossed")
                updateText(strToAdd)
            }

        } else {
            Log.i(TAG, "operators: stage 9 crossed")
            updateText(strToAdd)
        }

    }

    private fun numbers(strToAdd: String) {

        toast.cancel()
        updateText(strToAdd)


//        TODO(")9 => )*9")
//        TODO("09 => 9")


    }

    private fun updateText(strToAdd: String) {

        Log.i("TAG", "updating text....")

        val oldStr: String = binding.edEq.text.toString()
        val cursorPos: Int = binding.edEq.selectionStart

        val leftStr = oldStr.substring(0, cursorPos)
        val rightStr = oldStr.substring(cursorPos)

        binding.edEq.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
        binding.edEq.setSelection(cursorPos + strToAdd.length)

    }

    override fun onSensorChanged(event: SensorEvent?) {

        if(one && two) {
            one = false
            two = false
        }

        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val sides = event.values[0]

            val value : Double = Math.toDegrees(sides.toDouble())

            if (value in -600.0 .. -300.0) {
                if(two)
                {
                    return
                }
                one = false
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE

            } else if (value in 300.0 .. 600.0) {
                if(two)
                {
                    return
                }
                one = false
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

            } else {
                if(one) {
                    return
                }
                two = false
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }

    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


}