//package com.example.algorithms
//
//import java.util.*
//
//
//class Tree     // Пустое дерево
//{
//    private var rootNode // корневой узел
//            : Node? = null
//
//    fun findNodeByValue(value: Int): Node? { // поиск узла по значению
//        var currentNode = rootNode // начинаем поиск с корневого узла
//        while (currentNode!!.value != value) { // поиск покуда не будет найден элемент или не будут перебраны все
//            currentNode = if (value < currentNode.value) { // движение влево?
//                currentNode.leftChild
//            } else { //движение вправо
//                currentNode.rightChild
//            }
//            if (currentNode == null) { // если потомка нет,
//                return null // возвращаем null
//            }
//        }
//        return currentNode // возвращаем найденный элемент
//    }
//
//    fun insertNode(value: Int) { // метод вставки нового элемента
//        val newNode = Node() // создание нового узла
//        newNode.value = value // вставка данных
//        if (rootNode == null) { // если корневой узел не существует
//            rootNode = newNode // то новый элемент и есть корневой узел
//        } else { // корневой узел занят
//            var currentNode = rootNode // начинаем с корневого узла
//            var parentNode: Node?
//            while (true) // мы имеем внутренний выход из цикла
//            {
//                parentNode = currentNode
//                if (value == currentNode!!.value) {   // если такой элемент в дереве уже есть, не сохраняем его
//                    return  // просто выходим из метода
//                } else if (value < currentNode.value) {   // движение влево?
//                    currentNode = currentNode.leftChild
//                    if (currentNode == null) { // если был достигнут конец цепочки,
//                        parentNode!!.leftChild = newNode //  то вставить слева и выйти из методы
//                        return
//                    }
//                } else { // Или направо?
//                    currentNode = currentNode.rightChild
//                    if (currentNode == null) { // если был достигнут конец цепочки,
//                        parentNode!!.rightChild = newNode //то вставить справа
//                        return  // и выйти
//                    }
//                }
//            }
//        }
//    }
//
//    fun deleteNode(value: Int): Boolean // Удаление узла с заданным ключом
//    {
//        var currentNode = rootNode
//        var parentNode = rootNode
//        var isLeftChild = true
//        while (currentNode!!.value != value) { // начинаем поиск узла
//            parentNode = currentNode
//            if (value < currentNode.value) { // Определяем, нужно ли движение влево?
//                isLeftChild = true
//                currentNode = currentNode.leftChild
//            } else { // или движение вправо?
//                isLeftChild = false
//                currentNode = currentNode.rightChild
//            }
//            if (currentNode == null) return false // yзел не найден
//        }
//        if (currentNode.leftChild == null && currentNode.rightChild == null) { // узел просто удаляется, если не имеет потомков
//            if (currentNode == rootNode) // если узел - корень, то дерево очищается
//                rootNode = null else if (isLeftChild) parentNode!!.leftChild =
//                null // если нет - узел отсоединяется, от родителя
//            else parentNode!!.rightChild = null
//        } else if (currentNode.rightChild == null) { // узел заменяется левым поддеревом, если правого потомка нет
//            if (currentNode == rootNode) rootNode =
//                currentNode.leftChild else if (isLeftChild) parentNode!!.leftChild =
//                currentNode.leftChild else parentNode!!.rightChild = currentNode.leftChild
//        } else if (currentNode.leftChild == null) { // узел заменяется правым поддеревом, если левого потомка нет
//            if (currentNode == rootNode) rootNode =
//                currentNode.rightChild else if (isLeftChild) parentNode!!.leftChild =
//                currentNode.rightChild else parentNode!!.rightChild = currentNode.rightChild
//        } else { // если есть два потомка, узел заменяется преемником
//            val heir = receiveHeir(currentNode) // поиск преемника для удаляемого узла
//            if (currentNode == rootNode) rootNode =
//                heir else if (isLeftChild) parentNode!!.leftChild =
//                heir else parentNode!!.rightChild = heir
//        }
//        return true // элемент успешно удалён
//    }
//
//    // метод возвращает узел со следующим значением после передаваемого аргументом.
//    // для этого он сначала переходим к правому потомку, а затем
//    // отслеживаем цепочку левых потомков этого узла.
//    private fun receiveHeir(node: Node?): Node? {
//        var parentNode = node
//        var heirNode = node
//        var currentNode = node!!.rightChild // Переход к правому потомку
//        while (currentNode != null) // Пока остаются левые потомки
//        {
//            parentNode = heirNode // потомка задаём как текущий узел
//            heirNode = currentNode
//            currentNode = currentNode.leftChild // переход к левому потомку
//        }
//        // Если преемник не является
//        if (heirNode != node.rightChild) // правым потомком,
//        { // создать связи между узлами
//            parentNode!!.leftChild = heirNode!!.rightChild
//            heirNode.rightChild = node.rightChild
//        }
//        return heirNode // возвращаем приемника
//    }
//
//    fun printTree() { // метод для вывода дерева в консоль
//        val globalStack: Stack<*> = Stack<Any?>() // общий стек для значений дерева
//        globalStack.push(rootNode)
//        var gaps = 32 // начальное значение расстояния между элементами
//        var isRowEmpty = false
//        val separator = "-----------------------------------------------------------------"
//        println(separator) // черта для указания начала нового дерева
//        while (isRowEmpty == false) {
//            val localStack: Stack<*> = Stack<Any?>() // локальный стек для задания потомков элемента
//            isRowEmpty = true
//            for (j in 0 until gaps) print(' ')
//            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
//                val temp =
//                    globalStack.pop() as Node // берем следующий, при этом удаляя его из стека
//                if (temp != null) {
//                    print(temp.value) // выводим его значение в консоли
//                    localStack.push(temp.leftChild) // соохраняем в локальный стек, наследники текущего элемента
//                    localStack.push(temp.rightChild)
//                    if (temp.leftChild != null || temp.rightChild != null) isRowEmpty = false
//                } else {
//                    print("__") // - если элемент пустой
//                    localStack.push(null)
//                    localStack.push(null)
//                }
//                for (j in 0 until gaps * 2 - 2) print(' ')
//            }
//            println()
//            gaps /= 2 // при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
//            while (localStack.isEmpty() == false) globalStack.push(localStack.pop()) // перемещаем все элементы из локального стека в глобальный
//        }
//        println(separator) // подводим черту
//    }
//
//
//    internal class Node {
//        var value // ключ узла
//                = 0
//        var leftChild // Левый узел потомок
//                : Node? = null
//        var rightChild // Правый узел потомок
//                : Node? = null
//
//        fun printNode() { // Вывод значения узла в консоль
//            println(" Выбранный узел имеет значение :$value")
//        }
//
//        override fun toString(): String {
//            return "Node{" + "value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + '}'
//        }
//    }
//}