package com.example.algorithms.Patterns

class Tamplate {
}

abstract class Pizza { // base class for all pizza types

    fun make() { // steps are the same for every pizza
        makeDough()
        applySauce()
        addIngredients()
        bake()
    }

    open fun bake() {
        // default implementation for each step
        // concrete classes needs to override only the distinctive ones
        println("baking for 20 minutes")
    }

    open fun addIngredients() {
        println("adding cheese")
    }

    open fun applySauce() {
        println("applying tomato sauce")
    }

    open fun makeDough() {
        println("making 30cm dough")
    }
}

class Pepperoni : Pizza() { // concrete type of pizza
    override fun addIngredients() { // overriding ingredients according to recipe
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }
    // but it's not controlling the process of making a pizza

    // all other methods are left with default implementation
}
class BigPepperoni : Pizza() { // same as previous but bigger

    override fun addIngredients() { // alas, duplicated implementation from previous class
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }

    override fun makeDough() { // the only difference from standard pepperoni
        println("making 50cm dough")
    }
}