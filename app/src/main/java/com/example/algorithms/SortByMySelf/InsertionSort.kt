package com.example.algorithms.SortByMySelf

fun insertionSort(array: IntArray) {
    val size = array.size
    for (i in 1 until size) {
        val temp = array[i]
        var j = i
        while (j > 0 && myGreater(array[j - 1], temp)) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = temp

    }
}


fun insert(intArray: IntArray) {
    val size = intArray.size
    for (i in 1 until size) {
        var j = i
        val temp = intArray[i]
        while (j > 0 && myGreater(intArray[j - 1], temp)) {
            intArray[j] = intArray[j-1]
             j--

        }
        intArray[j] = temp
    }
}


fun main() {
    val array = arrayListOf("", "23", "")
    val ar = intArrayOf(11, 26, 37, 49, 5, 9036, 11, 11, 444, 5996, 678)
    val ar1 = intArrayOf(141, 216, 377, 4009, 5, 9036, 11, 11, 444, 5996, 678)
    insert(ar1)

    for (i in ar1.indices) {
        println(ar1[i].toString())
    }
    println(array.size.toString())

}
