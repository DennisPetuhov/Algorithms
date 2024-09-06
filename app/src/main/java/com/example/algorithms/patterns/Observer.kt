package com.example.algorithms.patterns

import kotlin.properties.Delegates

class Observer {
}


interface TextChangedListener {

    fun onTextChanged(oldText: String, newText: String)
}

class PrintingTextChangedListener : TextChangedListener {

    private var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
        println(text)
    }
}

class TextView {

    val listeners = mutableListOf<TextChangedListener>()

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old, new) }
    }
}

fun main() {


    val textView = TextView()
    textView.listeners.add(PrintingTextChangedListener())



       textView.text = "Lorem ipsum"
       textView.text = "dolor sit amet"


}

class One{
    interface Observable<T> {
        val observers: MutableList<(T) -> Unit>

        fun addObserver(observer: (T) -> Unit) {
            observers.add(observer)
        }

        fun notifyObservers(data: T) {
            for (observer in observers) {
                observer(data)
            }
        }
    }

    // Класс наблюдаемого объекта
    class DataSource : Observable<Int> {
        override val observers = mutableListOf<(Int) -> Unit>()

        fun updateData(newValue: Int) {
            notifyObservers(newValue)
        }
    }

    fun main() {
        val dataSource = DataSource()

        // Добавление наблюдателя
        dataSource.addObserver { value ->
            println("Новое значение: $value")
        }

        // Имитация изменения данных
        dataSource.updateData(42)
    }
}
