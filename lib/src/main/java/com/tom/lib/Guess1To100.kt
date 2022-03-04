package com.tom.lib

import kotlin.random.Random

fun main() {
    val secret = Random.nextInt(100)+1
    println(secret)
    var num = 0
    var h = 100
    var l = 1
    var i =1
    while (num != secret && i!=4 ){
        println("Please enter a number($l to $h):")
//        num = readLine()!!.toInt()
        readLine()?.let {
            num = it.toInt()
            if (h > num &&  num > secret){
                h = num
                println("$l to $h")
            }else if (l<num && num < secret){
                l = num
                println("$l to $h")
            }else if (num == secret){
                println("You got it!")
                i = 2
            }else{
                println("Ｗhat's wrong with you?")
            }
        }
        i++
    }
    if (i == 4){
        println("HaHa!You're loser!")
    }
}

class Guess1To100 {
}