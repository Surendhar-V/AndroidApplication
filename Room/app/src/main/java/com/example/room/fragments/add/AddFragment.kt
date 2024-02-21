package com.example.room.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.data.User
import com.example.room.data.UserViewModel
import com.example.room.databinding.FragmentAddBinding


class addFragment : Fragment() {

    private lateinit var binding : FragmentAddBinding
    private lateinit var m_UserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentAddBinding.inflate(inflater, container, false)
        m_UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val age = binding.addAgeEt.text.toString()

        if(inputCheck(firstName , lastName , age)){
            val user = User(0 , firstName ,lastName , Integer.parseInt(age))
            m_UserViewModel.addUser(user)
            Toast.makeText(requireContext() , "Successfully Added !" ,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext() , "Fill out all the Entries" , Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(firstName : String ,lastName : String , age : String) : Boolean{

        return !(firstName.isEmpty()) && !(lastName.isEmpty()) && !(age.isEmpty())


    }

}