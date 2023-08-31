package com.example.algorithms

import kotlin.random.Random

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

fun <T : Comparable<T>> Array<T>.quickSort(start: Int = 0, end: Int = size - 1) {
    val array = this

    if (array.isEmpty()) return
    if (start >= end) return

    val pivotIndex = Random.nextInt(start, end + 1)
    val pivot = array[pivotIndex]

    var i = start
    var j = end

    while (i <= j) {
        while (array[i] < pivot) {
            i++
        }
        while (array[j] > pivot) {
            j--
        }
        if (i <= j) {
            array[i] = array[j].apply {
                array[j] = array[i]
            }
            i++
            j--
        }
    }

    if (i < end) quickSort(i, end)
    if (0 < j) quickSort(start, j)
}

fun <T : Comparable<T>> MutableList<T>.quickSort(start: Int = 0, end: Int = size - 1) {
    val list = this

    if (list.isEmpty()) return
    if (start >= end) return

    val pivotIndex = Random.nextInt(start, end + 1)
    val pivot = list[pivotIndex]

    var i = start
    var j = end

    while (i <= j) {
        while (list[i] < pivot) {
            i++
        }
        while (list[j] > pivot) {
            j--
        }
        if (i <= j) {
            list[i] = list[j].apply {
                list[j] = list[i]
            }
            i++
            j--
        }
    }

    if (i < end) quickSort(i, end)
    if (0 < j) quickSort(start, j)
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
