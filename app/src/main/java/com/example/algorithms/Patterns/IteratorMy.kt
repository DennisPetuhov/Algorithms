package com.example.algorithms.Patterns

class IteratorMy {
}



class Novella(val name: String)
class Novellas(val novellas: MutableList<Novella> = mutableListOf()) : Iterable<Novella> {
    override fun iterator(): Iterator<Novella> = NovellasIterator(novellas)
}
class NovellasIterator(val novellas: MutableList<Novella> = mutableListOf(), var current: Int = 0) : Iterator<Novella> {
    override fun hasNext(): Boolean = novellas.size > current
    override fun next(): Novella {
      println(current.toString()+"*")
        val novella = novellas[current]
        println(novella.toString() +"**")
        current++
        println(current.toString()+"***")
        println(novella.toString() +"****")
        return novella
    }
}
fun main(args: Array<String>) {
    val novellas = Novellas(mutableListOf(Novella("Test1"), Novella("Test2")))
val iterator=NovellasIterator()
    while (iterator.hasNext())
    {
        println()
    }
    novellas.forEach {
        println(it.name) }
}