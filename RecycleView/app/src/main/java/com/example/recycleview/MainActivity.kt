package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , MyAdapter.OnItemClickedListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList : ArrayList<Item>
    private lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        itemList = ArrayList()

        itemList.add(Item(R.drawable.fruit, "Fruits","Fresh Fruits from the Garden"))
        itemList.add(Item(R.drawable.vegitables, "Vegetables","Delicious Vegetables "))
        itemList.add(Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans"))
        itemList.add(Item(R.drawable.beverage, "Beverage","Juice, Tea, Coffee and Soda"))
        itemList.add(Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt"))
        itemList.add(Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks"))

        val layoutManager  = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        myAdapter = MyAdapter(itemList, this)
        recyclerView.adapter = myAdapter
        recyclerView.setHasFixedSize(true)

    }

    override fun itemClicked(position: Int) {
        Toast.makeText(applicationContext , "$position is clicked" , Toast.LENGTH_SHORT).show()
    }

}