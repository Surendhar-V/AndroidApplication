package com.example.homepage_fyp.model

import android.util.Log

class OrderItem {

    private var count = 0
    private lateinit var id : String
    private lateinit var itemName: String
    private lateinit var  itemPrice: String
    private lateinit var srcImg: String

    fun setOrder(cartList : ArrayList<OrderItem>?  , item: Item , count : Int) : ArrayList<OrderItem> {

        if(cartList == null){
            setOrderItem(Item() , 0)
            Log.e("Shop", "Exception thrown" , Exception("setOrder is called with null cartList"))
            return arrayListOf(OrderItem())
        }

//        for(element in cartList){
//           if(element.id == item.id){
//               element.count = count
//               return cartList
//           }
//        }

        setOrderItem(item , count)

        cartList.add(this)
        return cartList

    }

    private fun setOrderItem(item : Item , count : Int){
        this.id = "0"
        this.srcImg  = item.srcImg
        this.itemName = item.itemName
        this.itemPrice = item.itemPrice
        this.count = count
    }

    override fun toString(): String {
        return "$id  $itemName  $itemPrice  $count"
    }

}