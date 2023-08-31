package com.example.algorithms

class InterfaceProgramming {
}
interface Food{
    fun getNutrition()
}
class Cat(){
    fun getFood( eat:Food){
        eat.getNutrition()
    }
}

class Sausege():Food{
    override fun getNutrition() {
        println("SAUSEGE")
    }
}
class Wurst():Food{
    override fun getNutrition() {
       println("WURST")
    }

}

fun main() {
    val cat=Cat()
    val sausege =Sausege()
    cat.getFood(sausege)
    val wurst =Wurst()
    cat.getFood(wurst)
}