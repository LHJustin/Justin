package com.tom.bmi

import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.random.Random

class GuessNumber {
    enum class GameState() {
        INIT,BIGGER ,SMALLER,BINGO,END
    }
    var secreth = (1..100).random()
    var secrete = (1..10).random()
    var counth = 10
    var counte = 3
    var max = 100
    var mx = 10
    var min = 1
    var x = GameState.END
    var z = 0
    var end = false

    fun guessh(num: Int){
        counth--
        if (num == secreth) {
//            x = Resources.getSystem().getString(R.string.the_number)+"$num"
            x = GameState.BINGO
            end = true
        } else if (num > secreth && num < max) {
//             x = Resources.getSystem().getString(R.string.smaller)
            x = GameState.SMALLER
            max = num
        } else if (num < secreth && num > min) {
//            x =Resources.getSystem().getString(R.string.bigger)
            x = GameState.BIGGER
            min = num
        } else
//            x=Resources.getSystem().getString(R.string.wrong)
            x = GameState.INIT
    }

    fun guesse(num: Int){
        counte--
        if (num==secrete){
            x=GameState.BINGO
            end = true
        }else if (num>secrete && num<max){
            x=GameState.SMALLER
            max = num
        }else if (num<secrete && num>min){
            x=GameState.BIGGER
            min = num
        }else x=GameState.INIT
    }

    fun reset(){
        secreth = (1..100).random()
        secrete = (1..10).random()
        counth = 10
        counte = 3
        max = 100
        mx = 10
        min = 1
        z = 0
        end = false
    }
}