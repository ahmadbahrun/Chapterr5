package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivityMultippelBinding
import com.bahrun.chapter5.databinding.GameActivityBinding.inflate
import com.bahrun.chapter5.manager.Manager
import com.bahrun.chapter5.manager.MultippelManager
import com.bahrun.chapter5.model.PlayerConstans

class MultippelActivity : AppCompatActivity() {

    lateinit var hasil : String
    lateinit var hasilYangAkanKeluar : ImageView
    lateinit var resetGame : ImageButton

    private val binding: ActivityMultippelBinding by lazy {
        ActivityMultippelBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
        setOnClickStartGame()
    }

    fun initComponent(){
        hasilYangAkanKeluar = binding.ivResult
        resetGame = binding.ibRefresh
    }
    fun check(){
        when(PlayerConstans.PLAYER_ONE_WIN){

        }
    }

    fun setOnClickStartGame(){
        binding.ibRockLeft.setOnClickListener {
            hasil = MultippelManager().rulesGame("ROCK").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibPaperLeft.setOnClickListener {
            hasil = MultippelManager().rulesGame("PAPER").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibScissorsLeft.setOnClickListener {
            hasil = MultippelManager().rulesGame("SCISSORS").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }

        binding.ibRockRight.setOnClickListener {
            hasil = MultippelManager().rulesGame("ROCK").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibPaperRight.setOnClickListener {
            hasil = MultippelManager().rulesGame("PAPER").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
        binding.ibScissorsRight
            .setOnClickListener {
            hasil = MultippelManager().rulesGame("SCISSORS").toString()
            if (hasil == PlayerConstans.PLAYER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_winner)
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_lose)
            } else if (hasil == PlayerConstans.DRAW) {
                hasilYangAkanKeluar.setImageResource(R.drawable.ic_draw)
            }
        }
    }
    companion object{
        fun startActivityMultiple(context: Context){
        context.startActivity(Intent(context,MultippelActivity::class.java))
        }
    }
}