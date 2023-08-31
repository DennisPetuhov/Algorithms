package com.example.algorithms

class ProxyPattern {
}





object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Create math proxy
        val p: IMath = MathProxy()

        // Do the math
        println("4 + 2 = " + p.add(4.0, 2.0))
        println("4 - 2 = " + p.sub(4.0, 2.0))
        println("4 * 2 = " + p.mul(4.0, 2.0))
        println("4 / 2 = " + p.div(4.0, 2.0))
    }
}

/**
 * "Subject"
 */
interface IMath {
    fun add(x: Double, y: Double): Double
    fun sub(x: Double, y: Double): Double
    fun mul(x: Double, y: Double): Double
    fun div(x: Double, y: Double): Double
}

/**
 * "Real Subject"
 */
class Math : IMath {
    override fun add(x: Double, y: Double): Double {
        return x + y
    }

    override fun sub(x: Double, y: Double): Double {
        return x - y
    }

    override fun mul(x: Double, y: Double): Double {
        return x * y
    }

    override fun div(x: Double, y: Double): Double {
        return x / y
    }
}

/**
 * "Proxy Object"
 */
class MathProxy : IMath {
    private var math: Math? = null
    override fun add(x: Double, y: Double): Double {
        lazyInitMath()
        return math!!.add(x, y)
    }

    override fun sub(x: Double, y: Double): Double {
        lazyInitMath()
        return math!!.sub(x, y)
    }

    override fun mul(x: Double, y: Double): Double {
        lazyInitMath()
        return math!!.mul(x, y)
    }

    override fun div(x: Double, y: Double): Double {
        lazyInitMath()
        return math!!.div(x, y)
    }

    private fun lazyInitMath() {
        if (math == null) {
            math = Math()
        }
    }
}