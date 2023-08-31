package com.example.algorithms.Search

class FirstRepeated {
}

fun firstRepeat(array: IntArray):Int {
    val size = array.size
    val hm = HashMap<Int, Int>()
    for (i in 0 until size) {
        if (hm.containsKey(array[i])) {
            hm.put(array[i], 2)
        } else hm.put(array[i], 1)
    }

    for (i in 0 until size) {
        if (hm.get(array[i]) == 2){
            println(array[i])
            return array[i]

        }
    }
    return 0
}

fun main() {
    val intArray:IntArray = intArrayOf(1,2,3,4,5,6,78,9,0,44,65,3,22,4556,6)
    firstRepeat(intArray)

}
