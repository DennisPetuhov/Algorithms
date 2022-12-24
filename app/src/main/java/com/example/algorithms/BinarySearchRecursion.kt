package com.example.algorithms

import java.math.BigInteger

class BinarySearchRecursion {
}

fun main() {
//    println(fucktorial(30))
    val a: MutableList<Int> = mutableListOf(0, 5, 3, 88, 55, 166, 54, 8888, 5362)
    val b = a.toIntArray()
    val index = a.size - 1
//    println(summArrya(a, index))
    println(a)
    b.bubleSort()
    println(fibonnachi(2, BigInteger("1"), BigInteger("2")))


    var n = 1
    var result = fuctorialTail(5, n)
    println("Factorial of 5 is: $result")
    println(getFibonacciByIndexRecursive(3))

}


//To avoid infinite recursion, if...else (or similar approach)
//    can be used where one branch makes the recursive call and other doesn't.

fun fucktorial(i: Int): Int {
    return if (i == 1) i else i * fucktorial(i - 1)

}

fun summArrya(array: MutableList<Int>, index: Int): Int {

    return if (index <= 0) 0 else
        summArrya(array, index - 1) + array[index - 1]
}
//What is tail recursion?
//In normal recursion, you perform all recursive calls first, and calculate the result from
//return values at last (as show in the above example). Hence, you don't get result until all recursive calls are made.
//
//In tail recursion, calculations are performed first, then recursive calls are executed
//(the recursive call passes the result of your current step to the next recursive call).
//This makes the recursive call equivalent to looping, and avoids the risk of stack overflow.


// Kotlin program of factorial using tail-recursion
tailrec fun fuctorialTail(num: Int, x: Int): Int {
    ////    A recursive function is eligible for tail recursion if the function call to itself is the last operation it performs.
    return if (num == 1) x else fuctorialTail(num - 1, x * num)
}

tailrec fun fibonnachi(n: Int, first: BigInteger, second: BigInteger): BigInteger {
    return if (n == 0) first else fibonnachi(n - 1, second, first + second)
}

tailrec fun summArryaTail(array: Array<Int>, index: Int, s: Int = 0): Int {

    return if (index <= 0) s else
        summArryaTail(array, (index - 1), s + array[index - 1]) // tail Recursion
}


fun getFibonacciByIndexRecursive(n: Int): Long {
    if (n == 0) {
        return 0L
    }
    return if (n == 1) {
        1L
    } else {
        getFibonacciByIndexRecursive(n - 1) + getFibonacciByIndexRecursive(n - 2)
    }
}






fun binarySearchIterative(input: IntArray, eleToSearch: Int, low: Int, high: Int): Int {
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

fun IntArray.bubleSort() {
    var sorted = false
    while (!sorted) {
        sorted = true


        for (i in 1 until this.size) {
            var previos = this[i - 1]
            var current = this[i]
            if (previos > current) {
                this.swap(i - 1, i)
                sorted = false
            }
        }
    }
    println(this.toList())
}

fun IntArray.swap(index1: Int, index2: Int) {
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp


}




fun linerSearch(list: List<Int>, searchElement: Int): Int {
    for (i in list) {
        if (searchElement == list[i]) {
            return list[i]
        }


    }
    return -1
}


//1 2 3 4 5 6 7 8 9 10

fun binerySearch(list: List<Int>, searchElement: Int): Int {

    var low = 0
    var high = list.size - 1
    var med: Int
    while (low <= high) {
        med = low + ((high - low) / 2)

        when {
            searchElement > med -> low = med + 1
            searchElement == med -> return med
            searchElement < med -> high = med - 1
        }
    }

return -1
}

fun binerySearch1(list: List<Int>, searchElement: Int,low: Int, high: Int): Int {

//    var low = 0
//    var high = list.size - 1
    var med = low + ((high - low) / 2)
    while (low <= high) {


        when {
//            searchElement > med -> low = med + 1
            searchElement > med -> return  binerySearch1(list,searchElement,med+1,high)
            searchElement == med -> return med
//            searchElement < med -> high = med - 1
            searchElement < med -> return  binerySearch1(list,searchElement,low,med-1)
        }
    }

    return -1
}


