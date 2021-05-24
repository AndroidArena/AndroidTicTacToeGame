package com.app.tictactoegame.domain.Repository

interface WinningRepository {
   suspend fun callWinningPlayerLogic( row : Int,  col:Int , player:Int): Int

}