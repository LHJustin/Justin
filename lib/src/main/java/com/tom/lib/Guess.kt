package com.tom.lib

import kotlin.random.Random

fun main() {
    val secret = Random.nextInt(10)+1
    println(secret)
    var num = 0
    while (num != secret ) {
        println("Please enter a number (1~10):")
        num = readLine()!!.toInt()
        if (num > secret) {
            println("Smaller")
        }else if (num < secret) {
            println("Bigger")
        }else{
            println("You got it!")
        }
    }


}

class Guess {
}