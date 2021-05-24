package com.app.tictactoegame.data

import com.app.tictactoegame.data.Logics.TicTacToe1
import com.app.tictactoegame.domain.Repository.WinningRepository
import javax.inject.Inject

class WinningDataRepository @Inject constructor(var ticTacToe1: TicTacToe1) : WinningRepository {
     override  suspend fun callWinningPlayerLogic(row:Int, col : Int,  player :Int): Int {
         return ticTacToe1.move(row, col ,  player)
     }

 }