package com.example.groceryapplication.Resources

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import com.example.groceryapplication.Adapter.CategoryListAdapter
import com.example.groceryapplication.Adapter.ItemListAdapter
import com.example.groceryapplication.R
import com.example.groceryapplication.View.MainActivity
import com.example.groceryapplication.View.Shop.ItemFragment
import com.example.groceryapplication.View.Shop.HomeFragment
import com.example.groceryapplication.databinding.FragmentHomeBinding
import com.example.groceryapplication.databinding.FragmentItemBinding
import com.example.groceryapplication.databinding.FragmentLoginBinding
import com.example.homepage_fyp.model.Category
import com.example.homepage_fyp.model.Item
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class mFirebase {

    private  var db : FirebaseFirestore
    private  var categoryRef : CollectionReference
    private  var itemRef  : CollectionReference
    private var auth : FirebaseAuth
    private var googleSignInClient : GoogleSignInClient
    private lateinit var context: MainActivity
    private lateinit var binding : FragmentLoginBinding

    constructor(){
        db = FirebaseFirestore.getInstance()
        categoryRef =  db.collection("CategoryImages")
        itemRef  = db.collection("MasterDatabase")
        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("685589120095-ltblm3d4bc7er399iclh71aomenbrfdf.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context , gso)

    }

    fun setCategoryArr(binding: FragmentHomeBinding, homeFragment: HomeFragment) = CoroutineScope(
        Dispatchers.IO).launch{

        try {
            val arr: ArrayList<Category> = ArrayList()
            val querySnapshot = categoryRef.get().await()

            for (document in querySnapshot.documents) {
                val category = document.toObject(Category::class.java)
                arr.add(category!!)
            }
            withContext(Dispatchers.Main) {
                binding.categoryrecyclerView.adapter = CategoryListAdapter(arr, homeFragment)
            }
        }catch (e : Exception){
            Log.i("Shop", "setCategoryArr: ${e.message}")
        }
    }

    fun populateItem(category: String, binding: FragmentItemBinding , listItems: ItemFragment)  = CoroutineScope(
        Dispatchers.IO).launch{
        Log.i("Shop", "Populating Items")
        try {

            val arr: ArrayList<Item> = ArrayList()
            val querySnapshot = itemRef.where(Filter.equalTo("itemCategory" , category)).get().await()
            Log.i("Shop", "populateItem: ${querySnapshot.documents}")
            for (document in querySnapshot.documents) {
                val category = document.toObject(Item::class.java)
                category!!.srcImg = document.get("srcImage").toString()
                Log.i("Shop", "populateItem: ${category}")
                arr.add(category!!)
            }
            withContext(Dispatchers.Main) {
                binding.recyclerViewListItems.adapter = ItemListAdapter(arr, listItems)
            }

        }catch (e : Exception){
            Log.e("Shop", "setCategoryArr: ${e.message}")
        }

    }

    private fun  signInGoogle(context : MainActivity , binding: FragmentLoginBinding){
        val signInIntent = googleSignInClient.signInIntent
        this.context = context
        this.binding = binding
        launcher.launch(signInIntent)
    }

    private val launcher = context.registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> if(result.resultCode == Activity.RESULT_OK){

        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        handleResults(task)
    }
    }
    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if(task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if( account != null ){
                updateUI(account)
            }
        }else{
            Toast.makeText( context , "Turn On your Mobile Data" , Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken ,null)
        auth.signInWithCredential(credential).addOnCompleteListener {

            if(it.isSuccessful){
               Navigation.findNavController(binding.root).navigate(R.id.action_login_to_home_nav)
            }else{
                Toast.makeText(context , "Turn On your Mobile Data+++" , Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun signOutGoogle(){
        auth.signOut()
        googleSignInClient.signOut().addOnCompleteListener {
            TODO("Clear All backstack")
        Navigation.findNavController(binding.root).navigate(R.id.action_global_login)
        }
    }
}