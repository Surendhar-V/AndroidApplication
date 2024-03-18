package com.example.homepage_fyp.model

import androidx.lifecycle.MutableLiveData

object CartItem {

    private val itemList : MutableLiveData<ArrayList<OrderItem>> = MutableLiveData(arrayListOf())

    fun addItem(newItem : Item , count : Int) : Boolean{

        val cartList : ArrayList<OrderItem>? = itemList.value
        val orderItem = OrderItem()
        val tempList = orderItem.setOrder(cartList , newItem , count)
        itemList.value = tempList
        return true

    }


    fun getCartItemList() : ArrayList<OrderItem>?{
        return itemList.value
    }



}