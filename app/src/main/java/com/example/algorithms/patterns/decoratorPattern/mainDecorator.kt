package com.example.algorithms.patterns.decoratorPattern

abstract class Topping: Pizza() {
    abstract val currentPizza: Pizza


    abstract override fun currentDescription(): String
}