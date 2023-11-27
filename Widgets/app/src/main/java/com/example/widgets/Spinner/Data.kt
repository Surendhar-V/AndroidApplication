package com.example.widgets.Spinner

import android.content.Context
import android.content.res.Resources
import com.example.widgets.R

class Data {

    companion object {

        lateinit var array:Array<String>

        fun getFruitList(context : Context): List<Fruit> {

            array = context.resources.getStringArray(R.array.fruits)

            var fruitList: ArrayList<Fruit> = ArrayList<Fruit>()

            val Nothing: Fruit = Fruit()
            Nothing.name = array.get(0)
            Nothing.image = R.drawable.ic_launcher_background
            fruitList.add(Nothing)

            val Avocado: Fruit = Fruit()
            Avocado.name = array.get(1)
            Avocado.image = R.drawable.avocado
            fruitList.add(Avocado)

            val Banana: Fruit = Fruit()
            Banana.name = array.get(2)
            Banana.image = R.drawable.banana
            fruitList.add(Banana)

            val Cocunut: Fruit = Fruit()
            Cocunut.name = array.get(3)
            Cocunut.image =R.drawable.coconut
            fruitList.add(Cocunut)

            val Guava: Fruit = Fruit()
            Guava.name = array.get(4)
            Guava.image = R.drawable.guava
            fruitList.add(Guava)

            val Lemon: Fruit = Fruit()
            Lemon.name = array.get(5)
            Lemon.image = R.drawable.lemon
            fruitList.add(Lemon)

            val Mango: Fruit = Fruit()
            Mango.name = array.get(6)
            Mango.image =R.drawable.mango
            fruitList.add(Mango)

            val Orange: Fruit = Fruit()
            Orange.name = array.get(7)
            Orange.image = R.drawable.orange
            fruitList.add(Orange)



            return fruitList

        }

    }
}