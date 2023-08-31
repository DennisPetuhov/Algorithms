package com.example.algorithms.SortByMySelf

class SelectionSort {
}
fun selectionSort(array: IntArray){
    val size = array.size
    for (i in 0 until size-1){
        var max = 0
        for (j in 1 until size-i){
            if (array[j]> array[max]){
                max = j
            }
            var temp = array[size-1-i]
            array[size-1-i] = array[max]
            array[max] =  temp

        }
    }

}
fun main() {
    val array = arrayListOf("", "23", "")
    val ar = intArrayOf(11, 26, 37, 49, 5, 9036, 11, 11, 444, 5996, 678)
    val ar1 = intArrayOf(141, 216, 377, 4009, 5, 9036, 11, 11, 444, 5996, 678)
    selectionSort(ar1)

    for (i in ar1.indices) {
        println(ar1[i].toString())
    }
    println(array.size.toString())

}