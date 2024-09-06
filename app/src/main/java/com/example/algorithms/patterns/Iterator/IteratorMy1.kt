package com.example.algorithms.patterns.Iterator

class IteratorMy1 {
}

interface MySelfIterator {

    fun hasNext(): Boolean

    fun next(): Item

    fun remove(): Unit
}


interface IterableCollection {
    fun createIterator(): MySelfIterator
}



class ConreteIterator(
    val collection: MutableList<Item> = mutableListOf(),
    var iterationState: Int = 0

) :  MySelfIterator {

    override fun hasNext(): Boolean {
     return  iterationState< collection.size

    }

    override fun next(): Item {

     val next = collection[iterationState]
        iterationState++
        return next
    }

    override fun remove() {
        TODO("Not yet implemented")
    }


}

data class Item(
    val name: String
)

class CollectionsOfItems() : IterableCollection {
    var collection:MutableList<Item> = mutableListOf()


    override fun createIterator(): MySelfIterator {
        return ConreteIterator(collection)
    }

}

fun main() {
    var collection= mutableListOf<Item>(Item("1"),Item("2"))
    var concreteCollectionsOfItems =CollectionsOfItems()
    concreteCollectionsOfItems.collection=collection
   val iterator = concreteCollectionsOfItems.createIterator()

   printIterator(iterator)
}

fun printIterator(currentIteratot:MySelfIterator){
     while (currentIteratot.hasNext()){
         println(currentIteratot.next())
     }
}