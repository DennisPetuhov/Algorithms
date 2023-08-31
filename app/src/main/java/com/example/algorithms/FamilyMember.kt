package com.example.algorithms


data class FamilyMember(val firstName : String,
                        val lastName : String,
                        val age : Int)
//    : Comparable<FamilyMember>
{

    /**
     * Having a compareTo method also overloads the comparison operators
     * >, >=, <, <=
     */
//    override fun compareTo(other: FamilyMember): Int {
//        val fName = firstName.compareTo(other.firstName)
//        val lName = lastName.compareTo(other.lastName)
//        return fName.compareTo(lName)
//    }
}

fun main(args : Array<String>){
    val belchers = mutableListOf(
        FamilyMember("Bob", "Belcher", 45),
        FamilyMember("Linda", "Belcher", 44),
        FamilyMember("Tina", "Belcher", 13),
        FamilyMember("Gene", "Belcher", 11),
        FamilyMember("Louise", "Belcher", 9))
    val bob = belchers[0]
    val gene = belchers[3]

    println("Before sort")
    println(belchers)
    println()

    println("Sorting using natural ordering")
//    belchers.sort()
    println(belchers)
    println()

    println("Sorting by age")
    belchers.sortBy { it.age }
    println(belchers)
    println()

    println("Testing operator overloading")
//    println("Bob > Gene? " + (bob > gene))
    }