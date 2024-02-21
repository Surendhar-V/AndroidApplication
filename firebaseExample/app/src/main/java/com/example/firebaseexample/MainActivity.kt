package com.example.firebaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseexample.databinding.ActivityMainBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : MainAdapter
    private lateinit var dbref : DatabaseReference
    private lateinit var userArrayList : ArrayList<MainModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
        userArrayList = arrayListOf()
        adapter = MainAdapter(userArrayList)
        binding.rv.adapter = adapter
        getUserData()

    }

    private fun getUserData(){

        dbref = FirebaseDatabase.getInstance().getReference("Students")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userArrayList.clear()

                for(userSnapshot in snapshot.children){
                    val user = userSnapshot.getValue(MainModel::class.java)
                    user?.let { userArrayList.add(it) }
                }

                adapter.notifyDataSetChanged()

//                if(snapshot.exists()){
//
//                    for(userSnapshot in snapshot.children){
//
//                        val user = userSnapshot.getValue(MainModel::class.java)
//                        userArrayList.add(user!!)
//
//                    }
//
//                    userRecyclerView.adapter = MainAdapter(userArrayList)


                }


            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}