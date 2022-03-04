package com.tom.lib

class Box (var x:Int,var y:Int,var z:Int){
    fun print(){
           println("${if (y>10 && y<=15)"你可以用BOX3,費用７０元" 
           else if (z>10 && z<=15)"你可以用BOX2,費用６０元" 
           else "你可以用BOX1,費用５０元"}")
    }
}


fun main() {
    print("請輸入長度：")
    var lo = readLine()!!.toInt()
    if (lo >10){
        print("已超出規格，請從新輸入長度：")
        lo = readLine()!!.toInt()
    }
    print("請輸入寬度：")
    var sh = readLine()!!.toInt()
    if (sh >15){
        print("已超出規格，請從新輸入寬度：")
        sh = readLine()!!.toInt()
    }
    print("請輸入高度：")
    var hi = readLine()!!.toInt()
    if (hi >15){
        print("已超出規格，請從新輸入高度：")
        hi = readLine()!!.toInt()
    }
    val box = Box(lo,sh,hi)
    box.print()
}