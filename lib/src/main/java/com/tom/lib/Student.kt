package com.tom.lib

open class Student (var name: String, var english:Int, var math: Int) {
    constructor() : this("", 0, 0) {
        println("Hi")
    }

    constructor(name: String) : this(name, 0, 0) {
    }

    //Fields
//    var name: String? = null
//    var english = 0
//    var math = 0
    //Methods
    fun print() {
        println("$name\t$english\t$math\t${average()}")
    }

    fun average() = (english + math) / 2
    fun highest() = if(english>math) english else math
    fun grading() = when(average()/10){
            in 9..10->'A'
            8->'B'
            7->'C'
            6->'D'
            else->'F'
        }
}
fun main() {
    val hank = Student("Hank")
    val jack = Student("Jack",85,65)
//    jack.name = "Jack"
//    jack.english = 85
//    jack.math = 65
//    println("${jack.name}\t${jack.english}\t${jack.math}")
    jack.print()
    hank.print()
}