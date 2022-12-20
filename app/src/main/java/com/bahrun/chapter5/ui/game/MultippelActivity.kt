package com.bahrun.chapter5.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.bahrun.chapter5.R
import com.bahrun.chapter5.databinding.ActivityMultippelBinding
import com.bahrun.chapter5.databinding.GameActivityBinding.inflate
import com.bahrun.chapter5.manager.Manager
import com.bahrun.chapter5.manager.MultippelManager
import com.bahrun.chapter5.model.PlayerConstans
import com.bahrun.chapter5.ui.onboarding.entername.EnterNameFragment


const val ROCK_LEFT = "ROCK LEFT"
const val PAPER_LEFT = "ROCK LEFT"
const val SCISSORS_LEFT = "ROCK LEFT"

const val ROCK_RIGHT = "ROCK RIGHT"
const val PAPER_RIGHT = "ROCK RIGHT"
const val SCISSORS_RIGHT = "ROCK RIGHT"
class MultippelActivity : AppCompatActivity() {

    lateinit var hasil : String
    lateinit var hasilYangAkanKeluar : ImageView
    lateinit var resetGame : ImageButton

    lateinit var ROCK_LEFT : ImageButton
    lateinit var PAPER_LEFT : ImageButton
    lateinit var SCISSORS_LEFT : ImageButton

    lateinit var ROCK_RIGHT : ImageButton
    lateinit var PAPER_RIGHT : ImageButton
    lateinit var SCISSORS_RIGHT : ImageButton

    lateinit var result : String




    private val binding: ActivityMultippelBinding by lazy {
        ActivityMultippelBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
        setOnClickStartGame()
        navteToMenu()
        setOnClickStartGame()
        reset()

    }

    fun initComponent(){
        hasilYangAkanKeluar = binding.ivResult
        resetGame = binding.ibRefresh

        ROCK_LEFT = binding.ibRockLeft
        PAPER_LEFT = binding.ibPaperLeft
        SCISSORS_LEFT = binding.ibScissorsLeft

        ROCK_RIGHT = binding.ibRockRight
        PAPER_RIGHT =binding.ibPaperRight
        SCISSORS_RIGHT =binding.ibScissorsRight

    }
    fun buttonLeft(){
        listOf(
            ROCK_LEFT,
            PAPER_LEFT,
            SCISSORS_LEFT
        )
    }
    fun getChoosePlayerOne(optionPlayerOne:String){
        binding.tvPlayer1.text = optionPlayerOne
        if (optionPlayerOne == "ROCK"){
            binding.ibRockLeft.visibility = View.INVISIBLE
            binding.ibPaperLeft.visibility = View.INVISIBLE
            binding.ibScissorsLeft.visibility = View.INVISIBLE
            binding.tvPlayer1.visibility = View.INVISIBLE
        }else if(optionPlayerOne == "PAPER"){
            binding.ibRockLeft.visibility = View.INVISIBLE
            binding.ibPaperLeft.visibility = View.INVISIBLE
            binding.ibScissorsLeft.visibility = View.INVISIBLE
            binding.tvPlayer1.visibility = View.INVISIBLE
        }else if(optionPlayerOne == "SCISSORS"){
            binding.ibRockLeft.visibility = View.INVISIBLE
            binding.ibPaperLeft.visibility = View.INVISIBLE
            binding.ibScissorsLeft.visibility = View.INVISIBLE
            binding.tvPlayer1.visibility = View.INVISIBLE
        }
    }
    fun getChoosePlayerTwo(optionPlayerTwo:String){
        binding.tvPlayer2.text = optionPlayerTwo

        if(optionPlayerTwo == "ROCK"){
            binding.ibRockRight.visibility = View.INVISIBLE
            binding.ibPaperRight.visibility = View.INVISIBLE
            binding.ibScissorsRight.visibility = View.INVISIBLE
            binding.tvPlayer2.visibility = View.INVISIBLE
        }else if (optionPlayerTwo == "PAPER"){
            binding.ibRockRight.visibility = View.INVISIBLE
            binding.ibPaperRight.visibility = View.INVISIBLE
            binding.ibScissorsRight.visibility = View.INVISIBLE
            binding.tvPlayer2.visibility = View.INVISIBLE

        }else if(optionPlayerTwo == "SCISSORS"){
            binding.ibRockRight.visibility = View.INVISIBLE
            binding.ibPaperRight.visibility = View.INVISIBLE
            binding.ibScissorsRight.visibility = View.INVISIBLE
            binding.tvPlayer2.visibility = View.INVISIBLE

        }
    }
    fun starGame (){
        var playerOneOption = binding.tvPlayer1.text.toString()
        var playerTwoOption = binding.tvPlayer2.text.toString()
       result = MultippelManager().rulesGame(playerOneOption, playerTwoOption)
        if (result == PlayerConstans.PLAYER_ONE_WIN){
            dialogWinner(PlayerConstans.PLAYER_ONE_WIN)
        }else if(result == PlayerConstans.PLAYER_TWO_WIN){
            dialogWinner(PlayerConstans.PLAYER_TWO_WIN)
        }else {
            dialogDraw()
        }
    }

    fun navteToMenu(){
        binding.ibIcClose.setOnClickListener { EnterNameFragment().navigateToMenu(name = String()) }
    }
    fun reset(){
        binding.ibRefresh.setOnClickListener {
            binding.ibRockLeft.visibility = View.VISIBLE
            binding.ibPaperLeft.visibility = View.VISIBLE
            binding.ibScissorsLeft.visibility = View.VISIBLE
            binding.tvPlayer1.visibility = View.VISIBLE

            binding.ibRockRight.visibility = View.VISIBLE
            binding.ibPaperRight.visibility = View.VISIBLE
            binding.ibScissorsRight.visibility = View.VISIBLE
            binding.tvPlayer2.visibility = View.VISIBLE
        }
    }


    fun setOnClickStartGame(){
        binding.ibRockLeft.setOnClickListener {
            getChoosePlayerOne(PlayerConstans.ROCK)
        }
        binding.ibPaperLeft.setOnClickListener {
            getChoosePlayerOne(PlayerConstans.PAPER)
        }
        binding.ibScissorsLeft.setOnClickListener {
            getChoosePlayerOne(PlayerConstans.SCISSORS)
        }


        binding.ibRockRight.setOnClickListener {
            getChoosePlayerTwo(PlayerConstans.ROCK)
            starGame()
        }
        binding.ibPaperRight.setOnClickListener {
            getChoosePlayerTwo(PlayerConstans.PAPER)
            starGame()
        }
        binding.ibScissorsRight.setOnClickListener {
            getChoosePlayerTwo(PlayerConstans.SCISSORS)
            starGame()
        }

    }

    fun dialogWinner(winner:String){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("GAME RESULT")
        dialog.setMessage("VICTORY $winner")
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
            reset()
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
            reset()
        }
        dialog.setNegativeButton("Back To Menu"){dialogInterface,p1 ->
            EnterNameFragment().navigateToMenu(name = String())
        }
        dialog.show()
    }
    companion object{
        fun startActivityMultiple(context: Context){
        context.startActivity(Intent(context,MultippelActivity::class.java))
        }
    }
}