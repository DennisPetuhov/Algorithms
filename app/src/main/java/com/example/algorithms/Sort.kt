package com.example.algorithms

class Sort {
}

fun main() {
    val a = listOf<Int>(
        3,
        6,
        2,
        3,
        45,
        768,
        12314,
        86,
        2344,
        765,
        76,
        455,
        3546,
        75,
        89,
        3445,
        123,
        432,
        456,
        765,
        67867,
        47776867,
        9877,
        895,
        6678,
        36
    )

    println(mergeSort(a))
//    println(quickSort(a))
}





fun quickSort(list: List<Int>): List<Int> {
    if (list.count() < 2) {
        return list
    }
    val pivot = list[list.count() / 2]
    val less = list.filter {
        it < pivot
    }
    val medium = list.filter { it == pivot }
    val greater = list.filter {
        it > pivot
    }
    return (quickSort(less) + medium + quickSort(greater))
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val medium = list.size / 2
    val left = list.subList(0, medium)
    val right = list.subList(medium, list.size)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    var newList: MutableList<Int> = mutableListOf()
    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }
    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList
}
