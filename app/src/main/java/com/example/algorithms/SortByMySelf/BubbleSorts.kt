package com.example.algorithms.SortByMySelf


class BubbleSorts {

}

//Each time the inner loop execute for (n-1), (n-2), (n-3) +..... + 3 + 2 + 1 = O(n^2) Worst-case
fun bubbleSort(array: ArrayList<Int>) {

    var arraySize = array.size
    var i = 0
    while (i < arraySize - 1) {
        var j = 0
        while (j < arraySize - i - 1) {
            if (myGreater(array[j], array[j + 1])) {
                var temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp

            }
            j++
        }
        i++
    }
}


//By applying this improvement, the best-case performance of this algorithm is improved when an array
//is nearly sorted. In this case, we just need a single pass and the best-case complexity is O(n)

fun bubbleSortModified(array: ArrayList<Int>) {
    var arraySize = array.size
    var i = 0
    var sorted = true
    while (sorted && i < arraySize - 1) {
        sorted = false
        var j = 0
        while (j < arraySize - i - 1) {
            if (myGreater(array[j], array[j + 1])) {

                var temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
                sorted = true


            }
            j++
        }
        i++
    }
}



fun bubble(array: ArrayList<Int>){
    val size = array.size
    var i = 0
    var sorted = true
    while (i < size-1 && sorted){
        sorted = false
        var j = 0
        while (j < size-i-1){
            if ( myGreater(array[j], array[j+1])){
                var temp = array[j]
                array[j]= array[j+1]
                array[j+1] = temp
                sorted = true
            }

            j++
        }
        i++


    }
}





fun main() {
    val ar = arrayListOf<Int>(11, 26, 37, 49, 5, 9036, 11, 11, 444, 5996, 678)
    val ar1 = arrayListOf<Int>(141, 216, 377, 4009, 5, 9036, 11, 11, 444, 5996, 678)
    bubbleSort(ar)
    bubble(ar1)

    for (i in ar1.indices) {
        println(ar1[i].toString())
    }

}