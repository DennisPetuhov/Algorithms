package com.example.algorithms.Search

class Window {
}
fun slidingWindowMaxSum(data: List<Int>, windowSize: Int): Int {
    require(windowSize > 0 && windowSize <= data.size) { "Неправильный размер окна" }

    var maxSum = 0

    // Вычисляем сумму для первого окна
    for (i in 0 until windowSize) {
        maxSum += data[i]
    }

    var currentSum = maxSum

    // Проходимся по остальным окнам
    for (i in windowSize until data.size) {
        currentSum = currentSum - data[i - windowSize] + data[i]
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

fun main() {
    val data = listOf(2, 4, 6, 8, 10, 12, 14, 16)
    val windowSize = 3

    val maxSum = slidingWindowMaxSum(data, windowSize)
    println("Максимальная сумма в скользящем окне размером $windowSize: $maxSum")
}