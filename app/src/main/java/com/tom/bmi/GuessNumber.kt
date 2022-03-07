package com.tom.bmi

import kotlin.random.Random

class GuessNumber {
    var secret = Random.nextInt(100)+1
    var count = 10
    var x = 0
    var y = ""
    fun ran(){
        count--
        when(x){
            1->y="Seriously?"
            2->y="What's wrong with you?"
            else ->y="......."
        }
    }
}