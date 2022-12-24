package com.example.algorithms

import java.util.concurrent.atomic.AtomicBoolean

val ab = AtomicBoolean(true)
fun main() {
   observe()
   observe()
   observe()
   observe()
}
fun observe(){
    var isSuccess: Boolean = ab.compareAndSet(true, false) //(current value != expectedValue)
    if (isSuccess){
        println("isSuccess")
    }

}

