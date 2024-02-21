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
import com.example.converters.databinding.FragmentAreaBinding
import com.example.converters.databinding.FragmentDataBinding

class data : Fragment() {

    val binding : FragmentDataBinding by lazy {
        FragmentDataBinding.inflate(layoutInflater)
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

        arr1 = resources.getStringArray(R.array.data)
        arr2 = resources.getStringArray(R.array.data)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       initiateEditext()
       setupAdapter()
       setupUnits()
        convert()

    }

    private fun setupAdapter(){
        spinner1 = binding.dataSpinner1
        spinner2 = binding.dataSpinner2

        adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,arr1)
        adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,arr2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter1

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2

        binding.dataEd1.showSoftInputOnFocus = false
        binding.dataEd2.showSoftInputOnFocus = false

    }

    private fun initiateEditext(){

        binding.dataEd1.setText(prevString1)
        binding.dataEd2.setText(prevString2)

    }

    private fun setupUnits(){

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
                binding.dataUnit1.text = unit1

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
                binding.dataUnit2.text = unit2

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }

    }
    private fun convert(){


        binding.dataEd1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                helper()
                prevString1 = s.toString()
            }
        })


        binding.dataEd2.addTextChangedListener(object : TextWatcher {
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

    private  fun helper(){

    }

}