package com.example.algorithms.Patterns.Fabric

interface Transport{

}
class Car:Transport {
}
class Moto():Transport{

}

class  Truck():Transport{

}

fun createCar():Transport{
    return Car()

}
abstract class AbstractFactory(){
    abstract fun createCar():Transport
    abstract fun createTruck():Transport
}


class MercedesFactory():AbstractFactory(){
    override fun createCar(): Transport {
        return Moto()
    }

    override fun createTruck(): Transport {
        return Truck()
    }

}
class NissanFactory():AbstractFactory(){
    override fun createCar(): Transport {
        return Car()
    }

    override fun createTruck(): Transport {
        return Truck()
    }
}

fun main() {
    println(createCar())

}