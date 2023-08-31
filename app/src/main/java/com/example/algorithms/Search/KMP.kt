package com.example.algorithms.Search

class KMP {
}
// Функция для вычисления массива LPS (наибольших длин префиксов и суффиксов) для образца
fun computeLPSArray(pattern: String): IntArray {
    val length = pattern.length
    val lps = IntArray(length) { 0 } // Создаем и инициализируем массив LPS нулями
    var len = 0 // Текущая длина наибольшего префикса-суффикса
    var i = 1 // Текущий индекс в строке образца

    // Цикл для построения массива LPS
    while (i < length) {
        if (pattern[i] == pattern[len]) { // Если символы совпадают
            len++ // Увеличиваем длину префикса-суффикса
            lps[i] = len // Записываем длину в массив LPS
            i++ // Переходим к следующему символу в образце
        } else {
            if (len != 0) {
                len = lps[len - 1] // "Откатываемся" на длину предыдущего LPS
            } else {
                lps[i] = 0 // Не нашли префикс-суффикс, записываем 0
                i++ // Переходим к следующему символу в образце
            }
        }
    }
    return lps // Возвращаем массив LPS
}

// Функция для поиска образца в тексте с использованием алгоритма КМП
fun KMPSearch(text: String, pattern: String) {
    val M = pattern.length // Длина образца
    val N = text.length // Длина текста
    val lps = computeLPSArray(pattern) // Вычисляем массив LPS для образца

    var i = 0 // Индекс текущего символа в тексте
    var j = 0 // Индекс текущего символа в образце

    // Цикл для поиска образца в тексте
    while (i < N) {
        if (pattern[j] == text[i]) { // Если символы совпадают
            i++ // Переходим к следующему символу в тексте
            j++ // Переходим к следующему символу в образце
        }

        if (j == M) { // Если достигли конца образца
            println("Найден образец на позиции ${i - j}")
            j = lps[j - 1] // "Откатываемся" на длину LPS для продолжения поиска
        } else if (i < N && pattern[j] != text[i]) { // Если символы не совпадают
            if (j != 0) {
                j = lps[j - 1] // "Откатываемся" на длину LPS для продолжения поиска
            } else {
                i++ // Переходим к следующему символу в тексте
            }
        }
    }
}

fun main() {
    val text = "ABABDABACDABABCABAB"
    val pattern = "ABABCABAB"
    KMPSearch(text, pattern) // Запускаем поиск образца в тексте
}