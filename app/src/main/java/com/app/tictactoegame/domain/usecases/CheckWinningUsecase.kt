package com.app.tictactoegame.domain.usecases

import com.app.tictactoegame.domain.Repository.WinningRepository
import javax.inject.Inject

class CheckWinningUsecase (var winningRepository: WinningRepository) {

    suspend fun checkWinner(  row : Int,  col:Int,player:Int) : Int{
     return winningRepository.callWinningPlayerLogic(row,col,player)
    }


}