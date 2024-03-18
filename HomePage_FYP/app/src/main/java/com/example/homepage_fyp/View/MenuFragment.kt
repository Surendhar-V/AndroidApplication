package com.example.homepage_fyp

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.homepage_fyp.databinding.FragmentMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater , container , false)
        // Inflate the layout for this fragment


        binding.customerCareMenuFrag.setOnClickListener {
            showCustomerDetails()
        }

        binding.accountMenuFrag.setOnClickListener {
            requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation_view).selectedItemId = R.id.accountFragment
        }

        binding.OrdersMenuFrag.setOnClickListener {
            val intent = Intent(requireContext() , Orders::class.java)
            startActivity(intent)
        }

        binding.historyMenuFrag.setOnClickListener {
            val intent = Intent(requireContext() , History::class.java)
            startActivity(intent)
        }

        binding.barCodeMenuFrag.setOnClickListener {
            BarcodeIdDialog()
        }



        return binding.root
    }


    private fun showCustomerDetails(){

        val dialog= Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.customer_care_dialogbox)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

    }

    private fun BarcodeIdDialog(){

        val dialog= Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.barcode_details)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

    }
}