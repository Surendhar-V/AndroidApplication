package com.example.coffe_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var arr : ArrayList<Item>
    lateinit var lv: ListView
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.lv)
        arr = ArrayList()

        val imgArr : Array<String> = resources.getStringArray(R.array.coffee)

        arr.add( Item(imgArr.get(0) , R.drawable.one ))
        arr.add( Item(imgArr.get(1) , R.drawable.two ))
        arr.add( Item(imgArr.get(2) , R.drawable.three ))
        arr.add( Item(imgArr.get(3) , R.drawable.four))
        arr.add( Item(imgArr.get(4) , R.drawable.five ))
        arr.add( Item(imgArr.get(5) , R.drawable.six))
        arr.add( Item(imgArr.get(6) , R.drawable.seven ))
        arr.add( Item(imgArr.get(7) , R.drawable.eight))
        arr.add( Item(imgArr.get(8) , R.drawable.nine ))
        arr.add( Item(imgArr.get(9) , R.drawable.ten ))
        arr.add( Item(imgArr.get(10) , R.drawable.eleven ))
        arr.add( Item(imgArr.get(11) , R.drawable.twelve ))

        adapter = MyAdapter(applicationContext , arr)

        lv.adapter = adapter

    }
}