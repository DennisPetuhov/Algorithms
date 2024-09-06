package com.example.algorithms.patterns

class ProxyByMemory {
}
interface MyProxyInterface{
    fun sum(imput:Int):Int
}
class MyClass():MyProxyInterface{
    override fun sum(imput: Int): Int {
        return imput+1
    }
}
class MyProxyClass():MyProxyInterface{
  private  var prox:MyClass? = null
    override fun sum(input: Int): Int {
        proxFun()
      return  prox!!.sum(input)

    }
    fun proxFun(){
        if (prox==null){
            prox=MyClass()
        }
    }

}

fun main() {
    val proxyMoxy:MyProxyInterface =MyProxyClass()
  println(  proxyMoxy.sum(1))
}