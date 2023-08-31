package com.example.algorithms.SortByMySelf

fun binarySearchIterative(input: ArrayList<Int>, eleToSearch: Int, low: Int, high: Int): Int {
    while (low <= high) {
        val mid = (low + high) / 2
        when {
            eleToSearch > input[mid] -> return binarySearchIterative(
                input,
                eleToSearch,
                mid + 1,
                high
            )

            eleToSearch < input[mid] -> return binarySearchIterative(
                input,
                eleToSearch,
                low,
                mid - 1
            )

            eleToSearch == input[mid] -> return mid
        }
    }
    return -1
}

fun binary(intArray: ArrayList<Int>, searchingElement: Int): Int {
    val low = intArray[0]
    val high = intArray.size - 1

    val mid = low + (low + high) / 2
    while (low <= high) {

        when {
            searchingElement > intArray[mid] -> {
                mid + 1
            }

            searchingElement == intArray [mid] -> {
                println(mid)
                return mid
            }

            searchingElement < intArray [mid] -> {
                mid - 1
            }
        }
    }
    return -1
}

fun binarySearchMy(input: ArrayList<Int>, eleToSearch: Int): Int {
    var low = 0
    var high = input.size - 1
    println(high)
    var med: Int
    while (low <= high) {
        med = (low + high ) / 2
        when {
            eleToSearch > input[med] -> low = med + 1
            eleToSearch == input[med] -> {
                println(med)
                return med}
            eleToSearch < input[med] -> high = med - 1
        }
    }
    return -1
}

fun binarySearch(arr: ArrayList<Int>, size: Int, value: Int): Boolean {
    var low = 0
    var high = size - 1
    var mid: Int
    while (low <= high) {
        mid = (low + high) / 2
        if (arr[mid] == value) {
            println(mid)
            return true
        } else if (arr[mid] < value) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return false
}

fun main() {
    val ar = arrayListOf<Int>(11, 26, 37, 49, 5, 9036, 11, 11, 444, 5996, 678)
    val ar1 = arrayListOf<Int>(141,155, 216, 377, 400, 500, 9036, 1100, 1122, 4443, 5996, 6789)
    binarySearchMy(ar1, 377)
    binary(ar1, 216)
//    binarySearchIterative(ar1,400,141,6789)
//    binarySearch(ar1,11,377)

//    for (i in ar1.indices) {
//        println(ar1[i].toString())
//    }

}