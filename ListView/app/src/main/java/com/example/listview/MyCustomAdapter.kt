package com.example.listview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(var context: Context ,var item : Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(p0: Int): Any {
        return item[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            // convertView: is a recycled View that you can reuse to
            //              improve the performance of your list.
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.my_list_item, parent, false)
            holder = ViewHolder()
            holder.textView = convertView!!.findViewById(R.id.text1)
            convertView.setTag(holder)
        } else {
            // Reusing the View (that's recycled)
            holder = convertView.tag as ViewHolder
        }

        // Set the data to the view
        holder.textView.setText(item.get(position))

        // Binding data to views within the convertView
        return convertView // Displays the data at a position in the data set

    }

    class ViewHolder{
        lateinit var textView : TextView
    }

}