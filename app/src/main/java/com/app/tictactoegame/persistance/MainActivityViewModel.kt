package com.app.tictactoegame.persistance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tictactoegame.data.Logics.TicTacToe1
import com.app.tictactoegame.domain.usecases.CheckWinningUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor( var checkWinningUsecase: CheckWinningUsecase) : ViewModel() {

    private val _player_staus = MutableLiveData<Int>()
    val player_staus: LiveData<Int> = _player_staus


    fun checkWinner(  row :Int , col :Int,player:Int) {
      viewModelScope.launch(Dispatchers.Default) {
          checkWinningUsecase.checkWinner(row,col,player).let {
              _player_staus.postValue(it)
          }
      }
    }

    override fun onCleared() {
        super.onCleared()
    }
}