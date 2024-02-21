package com.example.converters.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.converters.R
import com.example.converters.databinding.FragmentLengthBinding
import com.example.converters.databinding.FragmentMassBinding

class mass : Fragment() {

    val binding : FragmentMassBinding by lazy {
        FragmentMassBinding.inflate(layoutInflater)
    }

    lateinit var spinner1 : Spinner
    lateinit var spinner2 : Spinner
    lateinit var adapter1 : ArrayAdapter<String>
    lateinit var adapter2 : ArrayAdapter<String>
    lateinit var arr1 : Array<String>
    lateinit var arr2 : Array<String>
    var prevString1 = "0.0"
    var prevString2 = "0.0"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arr1 = resources.getStringArray(R.array.mass)
        arr2 = resources.getStringArray(R.array.mass)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       initiateEditext()
       setupAdapter()
       setupUnit()
       convert()

    }
    private fun convert(){


        binding.massEd1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                helper()
                prevString1 = s.toString()
            }
        })


        binding.massEd2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                helper()
                prevString2 = s.toString()
            }
        })

    }

    private fun helper(){

    }

    private fun setupAdapter(){

        spinner1 = binding.massSpinner1
        spinner2 = binding.massSpinner2

        adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,arr1)
        adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,arr2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter1

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2


        binding.massEd1.showSoftInputOnFocus = false
        binding.massEd2.showSoftInputOnFocus = false

    }


    private fun initiateEditext(){
        binding.massEd1.setText(prevString1)
        binding.massEd2.setText(prevString2)
    }

    private fun setupUnit(){

        spinner1.onItemSelectedListener = object : AdapterView.OnItemClickListener , AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var string1 = parent?.selectedItem.toString()
                string1 = string1.trim()

                var stringarr1 = string1.split(" ")
                var unit1 = stringarr1[stringarr1.size-1]
                unit1 = unit1.replace("(" ,"")
                unit1 = unit1.replace(")" ,"")
                binding.massUnit1.text = unit1

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemClickListener , AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var string2 = parent?.selectedItem.toString()
                string2 = string2.trim()

                var stringarr2 = string2.split(" ")
                var unit2 = stringarr2[stringarr2.size-1]
                unit2 = unit2.replace("(" ,"")
                unit2 = unit2.replace(")" ,"")
                binding.massUnit2.text = unit2

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }

    }


}