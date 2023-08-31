package com.example.algorithms.Patterns.AbstractFabric
interface Transport{

}
class Car:Transport {
}

class  Truck():Transport{

}

fun createCar():Transport{
    return Car()
}
fun main() {
    println(createCar())

}