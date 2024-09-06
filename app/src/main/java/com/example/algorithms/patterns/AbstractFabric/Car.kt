package com.example.algorithms.patterns.AbstractFabric
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