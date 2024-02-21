package com.example.weather_nr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.weather_nr.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchWeatherData("sriperumbudur")
        SearchCity()

    }

    private fun SearchCity(){

        val searchView = binding.searchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    fetchWeatherData(query)
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }


        })

    }
    private fun fetchWeatherData(cityName : String){

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

        val response = retrofit.getWeatherData(cityName,"d791a9f1fcacdab74102e4d52ed7361a", "metric")
        response.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(
                call: retrofit2.Call<WeatherApp>,
                response: Response<WeatherApp>
            ) {
                val responseBody = response.body()
                if(response.isSuccessful && responseBody != null){
                    val temperature = responseBody.main.temp
                    binding.temperature.text = "$temperature °C"
                    binding.humidity.text = "${responseBody.main.humidity} %"
                    binding.wind.text = "${responseBody.wind.speed} m/s"
                    binding.sunrise.text = time(responseBody.sys.sunrise.toLong())
                    binding.sunset.text = time(responseBody.sys.sunset.toLong())
                    binding.sea.text = "${responseBody.main.pressure} hPa"
                    val condition = responseBody.weather.firstOrNull()?.main?: "unknown"
                    binding.weather.text = condition
                    binding.condition.text = condition
                    binding.day.text = dayName(System.currentTimeMillis())
                    binding.date.text = date()
                    binding.cityName.text =  cityName
                    binding.minTem.text = "Max Temp : ${responseBody.main.temp_min} °C"
                    binding.maxTem.text = "Min Temp : ${responseBody.main.temp_max} °C"
                    binding.weather.text  = condition

                    changeImage(condition)
                }else{
                    Toast.makeText(this@MainActivity, "Data is unavailable. Try with different City",Toast.LENGTH_SHORT).show()
                }
            }

            private fun changeImage(condition :String) {
                when(condition){
                    "Haze" , "Partly Clouds" , "Clouds" , "Overcast" , "Mist" , "Foggy" -> {
                        binding.root.setBackgroundResource(R.drawable.colud_background)
                        binding.lottieAnimationView.setAnimation(R.raw.cloud)
                    }
                    "Clear Sky" , "Sunny" ,"Clear" -> {
                        binding.root.setBackgroundResource(R.drawable.sunny_background)
                        binding.lottieAnimationView.setAnimation(R.raw.sun)
                    }
                    "Light Rain" , "Drizzle" , "Moderate Rain" , "Showers" , "Heavy Rain" -> {
                        binding.root.setBackgroundResource(R.drawable.rain_background)
                        binding.lottieAnimationView.setAnimation(R.raw.rain)
                    }
                    "Light Snow" , "Moderate Snow" , "Heavy Snow" , "Blizzard"  -> {
                        binding.root.setBackgroundResource(R.drawable.snow_background)
                        binding.lottieAnimationView.setAnimation(R.raw.snow)
                    }
                    else -> {
                        binding.root.setBackgroundResource(R.drawable.sunny_background)
                        binding.lottieAnimationView.setAnimation(R.raw.sun)
                    }

                }

                binding.lottieAnimationView.playAnimation()
            }

            override fun onFailure(call: retrofit2.Call<WeatherApp>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }

        })
    }

    fun dayName(timestamp : Long): String{
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(Date())
    }

    fun date() : String{
        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return sdf.format(Date())
    }

    fun time(timestamp: Long) : String{
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp*1000))
    }

}