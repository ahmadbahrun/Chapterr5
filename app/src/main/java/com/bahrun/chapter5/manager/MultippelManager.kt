package com.bahrun.chapter5.manager

import com.bahrun.chapter5.model.Player
import com.bahrun.chapter5.model.PlayerConstans

class MultippelManager {
    val choice = listOf("ROCK", "PAPER", "SCISSORS")
    var checkWinner: String = ""


    fun rulesGame(playerOne:String, playerTwo:String):String{

        if (playerOne == PlayerConstans.ROCK && playerTwo == PlayerConstans.PAPER) {
            checkWinner = PlayerConstans.PLAYER_TWO_WIN
        } else if (playerOne == PlayerConstans.ROCK && playerTwo == PlayerConstans.SCISSORS) {
            checkWinner = PlayerConstans.PLAYER_ONE_WIN
        } else if (playerOne == PlayerConstans.PAPER && playerTwo == PlayerConstans.ROCK) {
            checkWinner = PlayerConstans.PLAYER_ONE_WIN
        } else if (playerOne == PlayerConstans.PAPER && playerTwo == PlayerConstans.SCISSORS) {
            checkWinner = PlayerConstans.PLAYER_TWO_WIN
        } else if (playerOne == PlayerConstans.SCISSORS && playerTwo == PlayerConstans.ROCK) {
            checkWinner = PlayerConstans.PLAYER_TWO_WIN
        } else if (playerOne == PlayerConstans.SCISSORS && playerTwo == PlayerConstans.PAPER) {
            checkWinner = PlayerConstans.PLAYER_ONE_WIN
        } else if (playerOne == playerTwo) {
            checkWinner = PlayerConstans.DRAW
        }
        return checkWinner
    }
}
