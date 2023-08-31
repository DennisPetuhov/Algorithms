package com.example.algorithms


class Rectangle(val length: Int, val breadth: Int): Comparable<Rectangle>{
    override fun compareTo(other: Rectangle): Int {
        val area1 = length * breadth
        val area2 = other.length * other.breadth

        // Comparing two rectangles on the basis of area
        if(area1 == area2){
            return 0;
        }else if(area1 < area2){
            return -1;
        }
        return 1;
    }
}

fun main(){
    var obj1 = Rectangle(5,5)
    var obj2 = Rectangle(4,4)
    var min = Rectangle(2,2)
    var max = Rectangle(9,9)

    // Using relational operator compare two rectangles
    println("Is rectangle one greater than equal"+
            " to rectangle two? ${obj1>obj2}")
    println("Is rectangle one greater than the " +
            "minimum sized rectangle? ${obj1.coerceAtLeast(min) == obj1} ")

    obj2 = Rectangle(10,10)
    println("Is rectangle two smaller than " +
            "the maximum sized rectangle? ${obj2.coerceAtMost(max) == obj2}")

    println("Is rectangle one within " +
            "the bounds? ${obj1.coerceIn(min,max) == obj1}")
}