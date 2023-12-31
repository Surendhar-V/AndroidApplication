package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import android.widget.TextView
import com.example.stopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import java.text.MessageFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var handler : Handler

    var second : Int = 0
    var minute : Int = 0
    var millisecondsTime : Long = 0
    var elapsedTime : Long = 0
    var startTime : Long = 0L
    var timeBuff : Long = 0L
    var updateTime : Long = 0L
    var millisecond : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(Looper.getMainLooper())

        binding.tvMinute.text = "00"
        binding.tvSecond.text = "00"
        binding.tvMilliSecond.text = "00"
        binding.textView3.text = ":"
        binding.textView5.text = ":"

        val runnable : Runnable = object : Runnable{
            override fun run() {

                millisecondsTime = SystemClock.uptimeMillis()-startTime
                updateTime = timeBuff + millisecondsTime
                second = (updateTime/1000).toInt() // Need to reduce to 60
                minute = second/60
                second %= 60
                millisecond = (updateTime % 100).toInt()

                binding.tvMilliSecond.text = String.format("%02d" , millisecond)
                binding.tvSecond.text = String.format("%02d" , second)
                binding.tvMinute.text = String.format("%02d" , minute)

                handler.postDelayed(this , 0)

            }
        }


        binding.startBtn.setOnClickListener{startBtn(runnable)}
        binding.stopBtn.setOnClickListener{stopBtn(runnable , millisecondsTime)}
        binding.resetBtn.setOnClickListener{resetBtn()}

}

    private fun startBtn( runnable : Runnable){

        startTime = SystemClock.uptimeMillis()
        handler.postDelayed(runnable , 0)
        binding.resetBtn.isEnabled = false
        binding.startBtn.isEnabled = false


    }

    private fun stopBtn(runnable : Runnable , millisecondTime: Long){

        timeBuff +=millisecondTime
        handler.removeCallbacks(runnable)
        binding.resetBtn.isEnabled = true
        binding.stopBtn.isEnabled = false
        binding.startBtn.isEnabled = true

    }

    private fun resetBtn(){

        binding.startBtn.isEnabled = true
        binding.stopBtn.isEnabled = true
        second = 0
        timeBuff = 0L
        minute = 0
        updateTime = 0L
        millisecond = 0

        binding.tvMinute.text = "00"
        binding.tvSecond.text = "00"
        binding.tvMilliSecond.text = "00"
        binding.textView3.text = ":"
        binding.textView5.text = ":"

    }

}