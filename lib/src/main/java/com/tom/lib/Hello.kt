package com.tom.lib

fun main() {
//    println("Hello world!")
    val p = Person()
    p.hello()
    val weight:Float = 64.5f
    val height = 1.7f
    val bmi = weight/(height*height)
    println(bmi)
    val isAdult = true
//
    var name:String? = null
//    name = "Hank"
    println(name?.uppercase())

}

