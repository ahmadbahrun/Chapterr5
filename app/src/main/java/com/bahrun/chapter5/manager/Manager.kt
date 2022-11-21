package com.bahrun.chapter5.manager

import com.bahrun.chapter5.R
import com.bahrun.chapter5.model.Player
import kotlin.random.Random

class Manager {
    //uji coba 1
    private val option = listOf("ROCK","PAPER","SCISSORS")
    private var computerOption: String = ""
    private var resultComputerVsPlayer: String = ""

    private val rule = mapOf(
        "ROCK - PAPER" to false,
        "ROCK - SCISSORS" to true,

        "PAPER - ROCK" to true,
        "PAPER - SCISSORS" to false,

        "SCISSORS - PAPER" to true,
        "SCISSORS - ROCK" to false
    )



    /*private val Rock: Int =  0
    private val Paper: Int = 1
    private val Scissors: Int = 2*/

    /*private lateinit var playerOne : Player
    private lateinit var playerTwo : Player*/

    /*fun initGame(){
        StartGame()
        playerOne = Player.PLAYER_ONE
        playerTwo = Player.PLAYER_TWO
    }

    private fun StartGame() {
        if (playerOne.rulesGame())
    }*/
    fun computerRandomOption():String = option[Random.nextInt(0,3)]
    fun starGame(playerOption:String): String {

        computerOption = computerRandomOption()


//        "ROCK - PAPER" to false,
//        "ROCK - SCISSORS" to true,
//
//        "PAPER - ROCK" to true,
//        "PAPER - SCISSORS" to false,
//
//        "SCISSORS - PAPER" to true,
//        "SCISSORS - ROCK" to false

        if (computerOption == "ROCK" && playerOption == "PAPER") {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = "Player Win"
        } else if (computerOption == "ROCK" && playerOption == "SCISSORS") {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = "Computer Win"
        } else if (computerOption == "PAPER" && playerOption == "ROCK") {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = "Computer Win"
        } else if (computerOption == "PAPER" && playerOption == "SCISSORS") {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = "Player Win"
        } else if (computerOption == "SCISSORS" && playerOption == "PAPER") {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = "Computer Win"
        } else if (computerOption == "SCISSORS" && playerOption == "ROCK") {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = "Player Win"
            } else if (computerOption == playerOption) {
//            draw
            resultComputerVsPlayer = "Draw"
        }

        return resultComputerVsPlayer
    }
    fun computerRandom(){

    }
    fun setDraw(){

    }
    fun setWin(){

    }
}
