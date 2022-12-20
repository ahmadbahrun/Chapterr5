package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
                dialogWinner()
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                dialoglose()
            } else if (hasil == PlayerConstans.DRAW) {
                dialogDraw()
            }
        }
        binding.ibPaperLeft.setOnClickListener {
            hasil = Manager().starGame("PAPER")
            if (hasil == PlayerConstans.PLAYER_WIN) {
                dialogWinner()
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                dialoglose()
            } else if (hasil == PlayerConstans.DRAW) {
                dialogDraw()
            }
        }
        binding.ibScissorsLeft.setOnClickListener {
            hasil = Manager().starGame("SCISSORS")
            if (hasil == PlayerConstans.PLAYER_WIN) {
                dialogWinner()
            } else if (hasil == PlayerConstans.COMPUTER_WIN) {
                dialoglose()
            } else if (hasil == PlayerConstans.DRAW) {
                dialogDraw()
            }
        }
    }
    fun reset(){
        resetGame.setOnClickListener { hasilYangAkanKeluar.setImageResource(R.drawable.ic_versus) }
    }
    fun closeToMenu(){
        binding.ibIcClose.setOnClickListener { EnterNameFragment().navigateToMenu(name = String()) }
    }

    fun dialogWinner(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("GAME RESULT")
        dialog.setMessage("VICTORY")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Play Again",){dialogInterface,_ ->
            reset()
        }
        dialog.setNegativeButton("Back To Menu"){dialogInterface,p1 ->
            EnterNameFragment().navigateToMenu(name = String())
        }
        dialog.show()
    }
    fun dialogDraw(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("GAME RESULT")
        dialog.setMessage("DRAW")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Play Again",){dialogInterface,_ ->
            resetGame.setOnClickListener { hasilYangAkanKeluar.setImageResource(R.drawable.ic_versus) }
        }
        dialog.setNegativeButton("Back To Menu"){dialogInterface,p1 ->
            EnterNameFragment().navigateToMenu(name = String())
        }
        dialog.show()
    }
    fun dialoglose(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("GAME RESULT")
        dialog.setMessage("DEFEAT")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Play Again",){dialogInterface,_ ->
            resetGame.setOnClickListener { hasilYangAkanKeluar.setImageResource(R.drawable.ic_versus) }
        }
        dialog.setNegativeButton("Back To Menu"){dialogInterface,p1 ->
            EnterNameFragment().navigateToMenu(name = String())
        }
        dialog.show()
    }


    companion object {
        fun startActivityComputer(context: Context) {
            context.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}
