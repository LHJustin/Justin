package com.tom.lib

//fun main() {
//    for (x in 2..9){
//        for (y in 1..9){
//            val z= " "
//            if (x*y < 10){
//                println("$x*$y=$z${x*y}")
//            }else{
//                println("$x*$y=${x*y}")
//            }
//
//        }
//    }
//}

fun main() {
    val n = 30
    println((1..n).random())
    for (x in 2..9){
        for (y in 1..9){
//            val z= if (x*y < 10) " " else ""
//            println("$x*$y=$z${x*y}")
            println("$x*$y=${if (x*y < 10) " " else ""}${x*y}")
        }
    }
}

//fun main() {
//    for (x in 2..9){
//        for (y in 1..9){
//            print("$x*$y=${x*y}\t")
//        }
//        println()
//    }
//}

class nine {
}