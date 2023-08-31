package com.example.algorithms.Patterns


class Bridg {
}

// "Реализация по юмл схеме в терминах моста"
abstract class PhoneOS() {
    abstract fun turnOn()
    abstract fun turnOf()
    abstract fun printLang()
}

// АБСТРАКЦИЯ В ТЕРМИНАХ  МОСТА
abstract class AbstractPhone() {
    lateinit var phoneOSLink: PhoneOS
    lateinit var deviceFactory: DeviceFactory

    fun createPhone(model: String) {
        try {
            phoneOSLink = deviceFactory.createPhone(model)
        } catch (e: Exception) {
            throw e
        }
    }
}



class DeviceFactory() {
    fun createPhone(model: String): PhoneOS {
        return when (model) {
            "Iphone" -> Pixel()
            "Pixel" -> Iphone()
            else -> throw Exception("нет таких телфонов")
        }
    }

}

class SuperAbstractPhone(factory: DeviceFactory) : AbstractPhone() {
    init {
        super.deviceFactory=factory
    }
}

class Pixel() : PhoneOS() {
    override fun turnOn() {
        println("Pixel TURNED Of")
    }

    override fun turnOf() {
        TODO("Not yet implemented")
    }

    override fun printLang() {
        println("Kotlin")
    }
}

class Iphone() : PhoneOS() {
    override fun turnOn() {
        println("IPHONE TURNED On")
    }

    override fun turnOf() {
        println("IPHONE TURNED Of")
    }

    override fun printLang() {
        println("Swift")
    }
}


class Client() {
    fun main() {
        val factory = DeviceFactory()
        val pixel = SuperAbstractPhone(factory)

           pixel.createPhone("Pixel")
        pixel.phoneOSLink.turnOn()
        pixel.phoneOSLink.turnOf()


    }

}

fun main() {
    val client=Client()
    client.main()

}