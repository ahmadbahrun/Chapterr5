package com.bahrun.chapter5.manager

import com.bahrun.chapter5.R
import com.bahrun.chapter5.model.Player
import com.bahrun.chapter5.model.PlayerConstans
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

        if (computerOption == PlayerConstans.ROCK && playerOption == PlayerConstans.PAPER) {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = PlayerConstans.PLAYER_WIN
        } else if (computerOption == PlayerConstans.ROCK && playerOption == PlayerConstans.SCISSORS) {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = PlayerConstans.COMPUTER_WIN
        } else if (computerOption == PlayerConstans.PAPER && playerOption == PlayerConstans.ROCK) {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = PlayerConstans.COMPUTER_WIN
        } else if (computerOption == PlayerConstans.PAPER && playerOption == PlayerConstans.SCISSORS) {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = PlayerConstans.PLAYER_WIN
        } else if (computerOption == PlayerConstans.SCISSORS && playerOption == PlayerConstans.ROCK) {
//            computer win or player loose
//            R.drawable.ic_lose
            resultComputerVsPlayer = PlayerConstans.COMPUTER_WIN
        } else if (computerOption == PlayerConstans.SCISSORS && playerOption == PlayerConstans.PAPER) {
//            computer loose or player win
//            R.drawable.ic_winner
            resultComputerVsPlayer = PlayerConstans.PLAYER_WIN
            } else if (computerOption == playerOption) {
//            draw
            resultComputerVsPlayer = PlayerConstans.DRAW
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
