package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.GameActivityBinding
import com.bahrun.chapter5.manager.Manager

class GameActivity : AppCompatActivity() {

    //private val option = listOf(binding.ibRockRight,binding.ibPaperRight,binding.ibScissorsRight)
    // mau bikin variabel yang seperti pak eko

    val computerChoose: String = ""
    lateinit var hasil: String
    lateinit var hasilYangAkanKeluar: ImageView
    lateinit var resetGame: ImageButton


    private val binding: GameActivityBinding by lazy {
        GameActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        initComponent()
        initializeListener()
        reset()

    }
    fun run(){
        initComponent()
        initializeListener()
    }

    fun initComponent() {
        hasilYangAkanKeluar = binding.ivResult
        resetGame = binding.ibRefresh
    }

    fun initializeListener() {
        binding.ibRockLeft.setOnClickListener {
            hasil = Manager().starGame("ROCK")
            if (hasil == "Player Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == "Computer Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == "Draw") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibPaperLeft.setOnClickListener {
            hasil = Manager().starGame("PAPER")
            if (hasil == "Player Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == "Computer Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == "Draw") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibScissorsLeft.setOnClickListener {
            hasil = Manager().starGame("SCISSORS")
            if (hasil == "Player Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == "Computer Win") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == "Draw") {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
    }
    fun reset(){
        resetGame.setOnClickListener { hasilYangAkanKeluar.setImageResource(R.drawable.ic_versus) }
    }

    //    fun startingGame(playerOption:String){
//        computerChoose == Manager().computerRandomOption()
//        if (computerChoose == "ROCK" && playerOption == "PAPER") {
////            computer loose or player win
//            R.drawable.ic_winner
//        } else if (computerChoose == "ROCK" && playerOption == "SCISSORS") {
////            computer win or player loose
//            R.drawable.ic_lose
//        } else if (computerChoose == "PAPER" && playerOption == "ROCK") {
////            computer win or player loose
//            R.drawable.ic_lose
//        } else if (computerChoose == "PAPER" && playerOption == "SCISSORS") {
////            computer loose or player win
//            R.drawable.ic_winner
//        } else if (computerChoose == "SCISSORS" && playerOption == "PAPER") {
////            computer win or player loose
//            R.drawable.ic_lose
//        } else if (computerChoose == "SCISSORS" && playerOption == "ROCK") {
////            computer loose or player win
//            R.drawable.ic_winner
//        }
//
//
//    }
    companion object {
        fun startActivityComputer(context: Context) {
            context.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}
