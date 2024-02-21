package com.example.recycleview

class Item() {

    var itemImg : Int = 0
        get() = field
        set(value) {
            field = value
        }

     var itemName : String = ""
         get() = field
        set(value) {
            field = value
        }

    var itemDesc : String = ""
        get() = field
        set(value) {
            field = value
        }

    constructor(itemImg : Int,  itemName : String ,  itemDesc : String ) : this() {
    this.itemImg = itemImg
    this.itemName  = itemName
    this.itemDesc =  itemDesc
    }



}