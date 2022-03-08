package com.tom.bmi

import android.content.Intent
import android.content.res.Resources
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }

    val g = GuessNumber()


    //    var max = 100
/*   var min = 1
    val sec = guess.secret
   var sec = Random.nextInt(100)+1
   var sec = (1..100).random()
    var count = 10
    var x = 0
    var y = ""
*/
    fun guess(view: View) {
        Log.d(TAG, "Testing")
//        println("Hahahaha")
//        println(binding.number.text.toString())
        var num = binding.edNumber.text.toString().toInt()
        g.guessh(num)
        val state = g.x
        val Mes = when(state){
            GuessNumber.GameState.BINGO-> getString(R.string.the_number)+"$num"
            GuessNumber.GameState.SMALLER -> getString(R.string.smaller)
            GuessNumber.GameState.BIGGER -> getString(R.string.bigger)
            else -> getString(R.string.wrong)
        }

        if (g.end) {
            binding.number.text = Mes
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.congratualation))
                .setMessage(getString(R.string.bingo))
                .setPositiveButton(getString(R.string.ok), null)
                .show()
        } else binding.number.text =
            Mes + getString(R.string.please_enter_a_number) + "${g.min}~${g.max}"

//        if (num>=max || num<=min){
//            x++
//            when(x) {
//                1 -> y = "Seriously?"
//                2 -> y = "What's wrong with you?"
//                else -> y = "......."
//            }
//            binding.number.text = "${y}Please enter a number($min-$max)"
//        }else if (num>sec && max>num){
//            max = num
//            binding.number.text = "Please enter a number($min-$max)"
//        }else if (num<sec && min<num){
//            min = num
//            binding.number.text = "Please enter a number($min-$max)"
//        }else {
//            binding.number.text = "Congratulation!The number is $num"
//            AlertDialog.Builder(this)
//                .setTitle("Congratulation")
//                .setMessage("You win!!!")
//                .setPositiveButton("OK",null)
//                .show()
//        }
//        count--
        binding.chance.text = getString(R.string.chance) + "${g.counth}"
        chance()
    }

    fun chance() {
        if (g.counth == 0) {
            binding.number.text = getString(R.string.lose)
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.Messange))
                .setMessage(getString(R.string.loser))
                .setPositiveButton(getString(R.string.ok), null)
                .show()
        }
    }

//    fun set(){
//        max = 100
//        min = 1
//        sec = Random.nextInt(100)+1
//        count = 10
//        x = 0
//        y = ""
//    }

    fun restart(view: View) {
//        val guess = GuessNumber()
//        set()
        g.reset()
        binding.number.text = getString(R.string.please_enter_a_number) + "${g.min}~${g.max}"
        binding.chance.text = getString(R.string.chance) + "${g.counth}"
    }

    fun change(view: View){
        val intent = Intent(this,Guessnum::class.java)
        startActivity(intent)
    }

//    fun start(view: View){
//        val g = GuessNumber()
//        g.ran(binding.)
//    }
}