package com.example.algorithms

import kotlin.random.Random

class TRYREMEMBER {
}


fun main() {
    val aa = intArrayOf(1, 3, 4, 24, 678, 2456, 9876, 2457, 9, 5352, 57, 3446, 8, 8)
    val a: MutableList<Int> = mutableListOf(0, 5, 3, 88, 3, 55, 16466, 556544, 8864688, 5362)
    val b = a.toIntArray()
//   aa.buble()
//    b.buble()

    var listI = "list I"
    var listJ = "list J"
    listI = listJ.apply {

        println(this + "***")
        listJ = listI
    }

    println("listJ = $listJ")
    println("listI = $listI")

    b.buble()
    a.veryquikSort()
    println(a+"!!!")
}

fun IntArray.buble() {
    var sorted = false
    while (!sorted) {
        sorted = true

        for (i in 1 until this.size) {
            var previos = this[i - 1]
            var current = this[i]


            if (previos > current) {
                this.swapp(i - 1, i)
                sorted = false

            }
        }
    }
    println(this.toList())
}

fun IntArray.swapp(previos: Int, current: Int) {
    var temp = this[previos]
    this[previos] = this[current]
    this[current] = temp


}

fun <T : Comparable<T>> MutableList<T>.veryquikSort(start: Int = 0, end: Int = size - 1) {
    val list = this
    if (list.isEmpty()) return
    if (start >= end) return
    val pivotIndex = Random.nextInt(start, end + 1)
    val pivotPoint = list[pivotIndex]
    var a = start
    var b = end
    while (a <= b) {
        while (list[a] < pivotPoint) {
            a++
        }
        while (list[b] > pivotPoint) {
            b--

        }
        if (a <= b) {
            list[a]=list[b].apply {
                list[b] = list[a]
            }
//            var temp = list[a]
//            list[a] = list[b]
//
//            list[b] = temp
            a++
            b--

        }
    }
    if (a<end) veryquikSort(a,end)
    if (b > 0) veryquikSort(start,b)


}