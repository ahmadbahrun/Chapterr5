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
import com.bahrun.chapter5.model.PlayerConstans
import com.bahrun.chapter5.ui.onboarding.entername.EnterNameFragment

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
        closeToMenu()

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
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibPaperLeft.setOnClickListener {
            hasil = Manager().starGame("PAPER")
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibScissorsLeft.setOnClickListener {
            hasil = Manager().starGame("SCISSORS")
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
    }
    fun reset(){
        resetGame.setOnClickListener { hasilYangAkanKeluar.setImageResource(R.drawable.ic_versus) }
    }
    fun closeToMenu(){
        binding.ibIcClose.setOnClickListener { EnterNameFragment().navigateToMenu(name = String()) }
    }


    companion object {
        fun startActivityComputer(context: Context) {
            context.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}
