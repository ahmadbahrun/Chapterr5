package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.isVisible
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
    fun setVisibility(playerOneVisible : Boolean){
        binding.ibRockLeft.isVisible = playerOneVisible
        binding.ibPaperLeft.isVisible = playerOneVisible
        binding.ibScissorsLeft.isVisible = playerOneVisible
    }

    fun set(){
        when(MultippelManager().getChoosePlayerOne("ROCK")){
            setVisibility(playerOneVisible = false)
        }
    }

    fun tryFun(){
        when(set()){
            MultippelManager().getChoosePlayerTwo("ROCK")
        }
    }


    fun setOnClickStartGame(){
        binding.ibRockLeft.setOnClickListener {
            tryFun()

        }

    }
    companion object{
        fun startActivityMultiple(context: Context){
        context.startActivity(Intent(context,MultippelActivity::class.java))
        }
    }
}