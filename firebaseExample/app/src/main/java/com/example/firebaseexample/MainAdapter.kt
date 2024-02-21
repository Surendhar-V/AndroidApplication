package com.example.firebaseexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter(private val userList : ArrayList<MainModel>):RecyclerView.Adapter<MainAdapter.myViewHolder>() {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


         var img : CircleImageView = itemView.findViewById(R.id.img1)
         var name : TextView = itemView.findViewById(R.id.nametext)
         var course : TextView = itemView.findViewById(R.id.coursetext)
         var email : TextView = itemView.findViewById(R.id.emailtext)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.main_item , parent , false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val model = userList[position]

        holder.name.text = model.name
        holder.course.text = model.course
        holder.email.text = model.email

        Glide.with(holder.img.context).load(model.surl).placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
            .circleCrop()
            .error(com.google.android.gms.base.R.drawable.googleg_disabled_color_18)
            .into(holder.img)

    }




}