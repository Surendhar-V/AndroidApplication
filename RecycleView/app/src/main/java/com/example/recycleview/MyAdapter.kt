package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var itemList: List<Item> , private var listner: MainActivity) :  RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout , parent , false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item : Item = itemList[position]

        holder.title.text = item.itemName
        holder.description.text = item.itemDesc
        holder.imageView.setImageResource(item.itemImg)

    }



    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

         var imageView : ImageView = itemView.findViewById(R.id.imageview)
         var title : TextView = itemView.findViewById(R.id.title_txt)
         var description : TextView = itemView.findViewById(R.id.description_text)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listner.itemClicked(position)
            }
        }


    }

    interface OnItemClickedListener {

        fun itemClicked( position: Int)


    }


}