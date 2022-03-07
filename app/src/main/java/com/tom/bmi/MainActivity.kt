package com.tom.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }
//    val guess = GuessNumber()
    var max = 100
    var min = 1
//    val sec = guess.secret
    var sec = Random.nextInt(100)+1
    var count = 10
    var x = 0
    var y = ""

    fun guess(view: View){
//        println("Hahahaha")
//        println(binding.number.text.toString())
        var num = binding.edNumber.text.toString().toInt()
        if (num>=max || num<=min){
            x++
            when(x) {
                1 -> y = "Seriously?"
                2 -> y = "What's wrong with you?"
                else -> y = "......."
            }
            binding.number.text = "${y}Please enter a number($min-$max)"
        }else if (num>sec && max>num){
            max = num
            binding.number.text = "Please enter a number($min-$max)"
        }else if (num<sec && min<num){
            min = num
            binding.number.text = "Please enter a number($min-$max)"
        }else {
            binding.number.text = "Congratulation!The number is $num"
        }
        count--
        binding.chance.text = "chance：$count"
        chance()
    }

    fun chance() {
        if (count==0){
            binding.number.text = "Hey!You lose!Restart the game."

        }
    }

    fun set(){
        max = 100
        min = 1
        sec = Random.nextInt(100)+1
        count = 10
        x = 0
        y = ""
    }

    fun restart(view: View){
//        val guess = GuessNumber()
        set()
        binding.number.text = "Please enter a number($min-$max)"
        binding.chance.text = "chance：$count"
    }
}