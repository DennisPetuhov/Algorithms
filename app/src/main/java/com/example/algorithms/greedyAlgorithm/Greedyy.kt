package com.example.algorithms.greedyAlgorithm

class Greedyy {
}

class Item(val myValue: Int, val weight: Int)

fun main() {
    val myList = listOf(Item(4, 1), Item(2, 2), Item(3, 3))

    fun foo(list: List<Item>, capacity: Int) {

        list.sortedByDescending {
            it.myValue.toDouble() / it.weight
        }
        var currentWeight: Int = 0
        var totalValue: Int = 0
        var restAmount = 0

        for (item in list) {
            if ((currentWeight + item.weight) <= capacity) {
                currentWeight += item.weight
                totalValue += item.myValue
            } else {
                restAmount = capacity - currentWeight
                totalValue += (restAmount*(item.myValue / item.weight )).toInt()
               break
            }

        }

    }
}