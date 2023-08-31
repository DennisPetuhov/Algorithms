package com.example.algorithms.Patterns

import com.example.algorithms.Patterns.Car.MyBuilder

class Builder {
}

class Car constructor( var engine: String? = null,var wheels: Int? = null) {


    inner class MyBuilder() {
        //        fun setEngine(engine: String) {
//            this@Car.engine = engine
//        }
        fun setEngine(engine: String):MyBuilder = apply { this@Car.engine = engine }

        fun setWheels(wheels: Int):MyBuilder {

            this@Car.wheels = wheels
            return this@MyBuilder
        }

        fun build(): Car {
//           return this@Car
            return Car(engine, wheels)
        }
    }


}


class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?
) {

    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null
    ) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }
}

fun main() {
//    val builder = Car()
//    MyBuilder()
//        .setEngine("kuugj")
//       .setEngine("nbkhb")
//       .setWheels(4)
//        .build()


    val foodOrder = FoodOrder.Builder()
        .bread("white bread")
//        .meat("bacon")
        .condiments("olive oil")
        .build()

}