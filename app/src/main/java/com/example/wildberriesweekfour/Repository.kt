package com.example.wildberriesweekfour

import android.util.ArraySet
import java.util.*

class Repository {
    var itemsChats = ArraySet<ChatData>()


    fun getChats(): List<ChatData> {

        while (itemsChats.size < 10){
            val random = Random().nextInt(19)
            itemsChats.add(allDataChats[random])
        }
        return itemsChats.toList()
    }

    fun getOneChat(): List<ChatData> {
        val random = Random().nextInt(19)
        while (itemsChats.size < 1){

            itemsChats.add(allDataChats[random])
        }
        return itemsChats.toList()
    }


    fun getAllMessagesChat(number: Int): List<Messages>{
        return allDataChats[number].listMessages
    }

    companion object val allDataChats: List<ChatData>
        get() = listOf(
            ChatData(0, R.drawable.morty, "Morty",
                listOf(Messages("Hi", false),
                    Messages("I'm Morty. How are you?", true),
                    Messages("Hello",true)), true),
            ChatData(1,R.drawable.morty, "Rick",
                listOf(Messages("Hi", false),
                Messages("I'm Rick. How are you?", true),
                Messages("Hello2",true)), true),
            ChatData(2,R.drawable.morty, "Jacob Philip",
                listOf(Messages("Hi", false),
                Messages("I'm Jacob Philip. How are you?", true),
                Messages("Hello3",true)), true),
            ChatData(3,R.drawable.morty, "Jerry Smith",
                listOf(Messages("Hi", false),
                    Messages("I'm Jerry Smith. How are you?", true),
                    Messages("Hello4",true)), true),
            ChatData(4,R.drawable.morty, "Summer Smith",
                listOf(Messages("Hi", false),
                    Messages("I'm Summer Smith. How are you?", true),
                    Messages("Hello5",true)), true),
            ChatData(5,R.drawable.morty, "Beth Smith",
                listOf(Messages("Hi", false),
                    Messages("I'm Beth Smith. How are you?", true),
                    Messages("Hello6",true)), true),
            ChatData(6,R.drawable.morty, "Mr. Poopybutthole",
                listOf(Messages("Hi", false),
                    Messages("I'm Mr. Poopybutthole. How are you?", true),
                    Messages("Hello7",true)), true),
            ChatData(7,R.drawable.morty, "Jessica",
                listOf(Messages("Hi", false),
                    Messages("I'm Jessica. How are you?", true),
                    Messages("Hello8",true)), true),
            ChatData(8,R.drawable.morty, "Brad",
                listOf(Messages("Hi", false),
                    Messages("I'm Brad. How are you?", true),
                    Messages("Hello9",true)), true),
            ChatData(9,R.drawable.morty, "Zeep Xanflorp",
                listOf(Messages("Hi", false),
                    Messages("I'm Zeep Xanflorp. How are you?", true),
                    Messages("Hello10",true)), true),
            ChatData(10,R.drawable.morty, "Evil Morty",
                listOf(Messages("Hi", false),
                    Messages("I'm Evil Morty. How are you?", true),
                    Messages("Hello11",true)), true),
            ChatData(11,R.drawable.morty, "Ethan",
                listOf(Messages("Hi", false),
                    Messages("I'm Ethan. How are you?", true),
                    Messages("Hello12",true)), true),
            ChatData(12,R.drawable.morty, "King Jellybean",
                listOf(Messages("Hi", false),
                    Messages("I'm King Jellybean. How are you?", true),
                    Messages("Hello13",true)), true),
            ChatData(13,R.drawable.morty, "Krombopulos Michael",
                listOf(Messages("Hi", false),
                    Messages("I'm Krombopulos Michael. How are you?", true),
                    Messages("Hello14",true)), true),
            ChatData(14,R.drawable.morty, "Leonard Smith",
                listOf(Messages("Hi", false),
                    Messages("I'm Leonard Smith. How are you?", true),
                    Messages("Hello15",true)), true),
            ChatData(15,R.drawable.morty, "Mr. Goldenfold",
                listOf(Messages("Hi", false),
                    Messages("I'm Mr. Goldenfold. How are you?", true),
                    Messages("Hello16",true)), true),
            ChatData(16,R.drawable.morty, "Mr. Meeseeks",
                listOf(Messages("Hi", false),
                    Messages("I'm Mr. Meeseeks. How are you?", true),
                    Messages("Hello17",true)), true),
            ChatData(17,R.drawable.morty, "Birdperson",
                listOf(Messages("Hi", false),
                    Messages("I'm Birdperson. How are you?", true),
                    Messages("Hello18",true)), true),
            ChatData(18,R.drawable.morty, "Snuffles",
                listOf(Messages("Hi", false),
                    Messages("I'm Snuffles. How are you?", true),
                    Messages("Hello19",true)), true),
            ChatData(19,R.drawable.morty, "Scary Terry",
                listOf(Messages("Hi", false),
                    Messages("I'm Scary Terry. How are you?", true),
                    Messages("Hello20",true)), true))



}