package com.example.menubar

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu ,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val itemId : Int = item.itemId

        if(itemId == R.id.action_home){
            Log.d("Main Activity" , "Home is touched")
            Toast.makeText(this , "You selected Home" , Toast.LENGTH_SHORT).show()
        }else if(itemId == R.id.action_search){
            Log.d("Main Activity" , "Search is touched")
            Toast.makeText(this , "You selected Search" ,Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)

    }


}

