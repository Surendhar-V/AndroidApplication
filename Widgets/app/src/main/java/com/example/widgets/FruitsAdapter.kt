package com.example.widgets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.widgets.Spinner.Fruit

class FruitsAdapter(var Context :Context, var fruitList: List<Fruit> ) : BaseAdapter() {


    override fun getCount(): Int = if (fruitList!=null) fruitList.size else 0


    override fun getItem(position: Int)= position


    override fun getItemId(position: Int) = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rootView : View = LayoutInflater.from(this.Context).inflate(R.layout.item_fruit , parent , false)

        val txtName : TextView = rootView.findViewById(R.id.name)
        val image : ImageView = rootView.findViewById(R.id.image)

        txtName.setText(fruitList.get(position).name)
        image.setImageResource(fruitList.get(position).image)

        return rootView

    }
}
