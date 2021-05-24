package com.app.tictactoegame.data.Logics


interface TicTacToeHelper {

    fun checkWinnerRowWise( row:Int, player: Int) :Int
    fun checkWinnerColumnWise(column:Int, player: Int):Int
    fun checkWinnerBackwordDiagnalWise( player: Int):Int
    fun checkWinnerForwardDiagnoalWise(player: Int):Int
}