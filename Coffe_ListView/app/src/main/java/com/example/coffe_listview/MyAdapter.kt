package com.example.coffe_listview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater

class MyAdapter(private var context : Context, private var items : ArrayList<Item>) : ArrayAdapter<Item>(context , R.layout.row , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val holder : ViewHolder
        var rootView  = convertView

        if(rootView == null){

            val inflater : LayoutInflater = LayoutInflater.from(context)
            holder = ViewHolder()
            rootView = inflater.inflate(R.layout.row,parent , false )

            holder.iv = rootView.findViewById(R.id.iv)
            holder.tv = rootView.findViewById(R.id.tv)

            rootView.tag = holder

        }else{
            holder = convertView?.tag as ViewHolder
        }

        val currentItem  = items.get(position)

        holder.tv.text = currentItem?.name
        if (currentItem != null) {
            holder.iv.setImageResource(currentItem.image)
        }

        return rootView!!


    }



    class ViewHolder{

        lateinit var  tv : TextView
        lateinit var iv : ImageView


    }

}