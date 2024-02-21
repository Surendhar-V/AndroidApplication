package com.example.landscapecheck

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.landscapecheck.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , SensorEventListener   {

    private lateinit var binding: ActivityMainBinding
    private var TAG: String = "TAG"

    private var one : Boolean = false
    private var two : Boolean = false

    private lateinit var sensorManager: SensorManager

    private var runnableString: String = "Its working"
    private val orientationHandler = Handler(Looper.getMainLooper())
    private val orientationRunnable = object : Runnable {
        override fun run() {
            Log.i("TAG", "${runnableString} $one")
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

        binding.btnSwitch.setOnClickListener {
            val currentOrientation = resources.configuration.orientation

            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                two = true
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else {
                one = true
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
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