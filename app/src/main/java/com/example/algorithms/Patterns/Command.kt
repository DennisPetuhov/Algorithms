package com.example.algorithms.Patterns

class Command {
}

interface OrderCommand {
    fun execute()
}

class OrderAddCommand(val id: Long) : OrderCommand {
    override fun execute() = println("Adding order with id: $id")
}

class OrderPayCommand(val id: Long) : OrderCommand {
    override fun execute() = println("Paying for order with id: $id")
}

class CommandProcessor {

    private val queue = ArrayList<OrderCommand>()

    fun addToQueue(orderCommand: OrderCommand): CommandProcessor =
        apply {
            queue.add(orderCommand)
        }

    fun processCommands(): CommandProcessor =
        apply {
            queue.forEach { it.execute() }
            queue.clear()
        }
}

fun main() {
    val commandProcessor = CommandProcessor()
    val orderCommand= OrderAddCommand(1)
    commandProcessor.addToQueue(orderCommand)
    commandProcessor.addToQueue(OrderAddCommand(2))
    commandProcessor.addToQueue(OrderPayCommand(3))
    commandProcessor.addToQueue(OrderPayCommand(4))
    commandProcessor.processCommands()
}