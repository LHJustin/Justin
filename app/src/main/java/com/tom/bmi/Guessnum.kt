package com.tom.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.tom.bmi.databinding.ActivityGuessnumBinding
import kotlin.concurrent.fixedRateTimer

class Guessnum : AppCompatActivity() {
    private lateinit var binding: ActivityGuessnumBinding
    val viewModel by viewModels<GuessViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessnumBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_guessnum)
        setContentView(binding.root)

//        viewModel.counter.observe(this){
//            binding.tvChance.setText(it.toString())
//        }
    }
//    var max = 10
//    var min = 1
//    var secret = (1..10).random()
//    var chance = 0

    var g = GuessNumber()

    fun start(view: View){
        var num = binding.edNum.text.toString().toInt()

        g.guesse(num)
        val state = g.x
        val Mes = when(state){
            GuessNumber.GameState.BINGO-> getString(R.string.bingo)
            GuessNumber.GameState.SMALLER -> getString(R.string.smaller)
            GuessNumber.GameState.BIGGER -> getString(R.string.bigger)
            else -> getString(R.string.wrong)
        }

//        var x = ""
//        if (num == secret) {
//            x="You win!"
//            reset()
//        }
//        else if (num>secret && max>num) {
//            x="Smaller"
//            max = num
//        }
//        else if (num<secret && min<num) {
//            x="Bigger"
//            min = num
//        }
//        else x="What's wrong with you?"

        if (g.end){
            g.reset()
            binding.tvTitle.text = getString(R.string.please_enter_a_number) + "${g.min}~${g.mx}"
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.Messange))
                .setMessage(Mes)
                .setPositiveButton(getString(R.string.ok),null)
                .show()
            count()
        }else{
        binding.tvTitle.text = getString(R.string.please_enter_a_number) + "${g.min}~${g.mx}"
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.Messange))
            .setMessage(Mes)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
        count()
        }
    }

    fun count(){
//        chance--
        binding.tvChance.text = getString(R.string.chance)+" ${g.counte}"
        if (g.counte==0){
//            reset()
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.Messange))
                .setMessage(getString(R.string.loser))
                .setPositiveButton(getString(R.string.ok),null)
                .show()
            g.reset()
            binding.tvTitle.text = getString(R.string.please_enter_a_number) + "${g.min}~${g.mx}"
            binding.tvChance.text = getString(R.string.chance)+" ${g.counte}"
        }
    }
    fun change(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

//    fun reset(){
//        secret = (1..10).random()
//    }

}