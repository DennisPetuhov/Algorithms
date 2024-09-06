package com.example.algorithms

class Strategy {
}

interface Iprinter {
    fun stringFormatterStrategyFromInterface(string: String): String
}

//class Printer(private val stringFormatterStrategy: (String) -> String)
class Printer(private var stringFormatterStrategy: Iprinter) {
    fun setStringFormatterStrategy(stringFormatterStrategy: Iprinter) {
        this.stringFormatterStrategy = stringFormatterStrategy
    }

    fun printString(string: String) {
//        println(stringFormatterStrat(string))
        println(stringFormatterStrategy.stringFormatterStrategyFromInterface(string))
    }
}

//val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }
val lowerCaseFormatter: Iprinter = object : Iprinter {
    override fun stringFormatterStrategyFromInterface(string: String): String {
        return string.lowercase()
    }
}

//val upperCaseFormatter = { it: String -> it.toUpperCase() }
val upperCaseFormatter: Iprinter = object : Iprinter {
    override fun stringFormatterStrategyFromInterface(string: String): String {
        return string.uppercase()
    }
}


fun main() {

    val inputString = "LOREM ipsum DOLOR sit amet"

    var lowerCasePrinter = Printer(lowerCaseFormatter)
    lowerCasePrinter.printString(inputString)
    lowerCasePrinter.setStringFormatterStrategy(upperCaseFormatter)
    lowerCasePrinter.printString(inputString)

//    val upperCasePrinter = Printer(upperCaseFormatter)
//    upperCasePrinter.printString(inputString)


}