package com.example.homepage_fyp.model


data class Item(

    var itemBarcodeString: String,
    var itemCategory: String,
    var itemId : String,
    var itemName: String,
    var itemOldPrice: String,
    var itemPrice: String,
    var srcImg: String,

    ) {
    constructor() : this("", "", "", "", "", "" , "")
}