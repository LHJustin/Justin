package com.tom.lib

class GraduateStudent(name:String, english:Int, math:Int)
    : Student(name,english,math) {

    }

fun main() {
    var jenny = GraduateStudent("Jenny",70,90)
    jenny.print()
}