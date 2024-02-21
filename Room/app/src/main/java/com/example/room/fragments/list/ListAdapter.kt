package com.example.room.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.User

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var id_text : TextView = itemView.findViewById(R.id.id_txt)
        var firstName_txt : TextView = itemView.findViewById(R.id.firstName_txt)
        var lastName_txt : TextView = itemView.findViewById(R.id.lastName_txt)
        var age_txt : TextView = itemView.findViewById(R.id.age_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row , parent , false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val currentItem = userList[position]
        holder.id_text.text = currentItem.id.toString()
        holder.firstName_txt.text = currentItem.firstName
        holder.lastName_txt.text = currentItem.lastName
        holder.age_txt.text = currentItem.age.toString()

    }

    fun setData(user : List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}