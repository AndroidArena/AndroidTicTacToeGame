package com.app.tictactoegame.persistance

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.tictactoegame.data.Logics.TicTacToe1
import com.app.tictactoegame.data.WinningDataRepository
import com.app.tictactoegame.databinding.ActivityMainBinding
import com.app.tictactoegame.domain.usecases.CheckWinningUsecase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {


    /** Player {player} makes a move at ({row}, {col}).
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */

    private var isfirstplayer_turn: Boolean = true
    private var binding: ActivityMainBinding? = null
    private var board_size = 2

    //Used Dagger-hilt for DI
    @Inject
    lateinit var ticTacToe1: TicTacToe1
    @Inject
    lateinit var winningDataRepository: WinningDataRepository

    // Injected all ViewModel dependencies through hilt
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        InitializeTicTacMatrix()
        registerObserver()
        setClickListners()

    }



    private fun setClickListners() {
        binding?.apply {
            button00.setOnClickListener(this@MainActivity)
            button01.setOnClickListener(this@MainActivity)
            button10.setOnClickListener(this@MainActivity)
            button11.setOnClickListener(this@MainActivity)

        }
    }

    private fun registerObserver() {
        viewModel.player_staus.observe(this, { player->
          val winner = if (player == 0) {
                "Next Player Turn"
            } else {
                "Congralutions ${player} is Winner"
            }
            Toast.makeText(this, winner, Toast.LENGTH_SHORT).show()
        })
    }

    private fun InitializeTicTacMatrix() {
        ticTacToe1.initializeBoard(board_size)

/*
        viewModel =
            ViewModelProvider(
                this, MainViewModelFactory(
                    CheckWinningUsecase(
                        winningDataRepository
                    )
                )
            ).get(
                MainActivityViewModel::class.java
            )
*/
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            binding?.button00?.id -> {
                setPlayerValueAndCallMove(binding?.button00, 0, 0)
            }
            binding?.button01?.id -> {
                setPlayerValueAndCallMove(binding?.button01, 0, 1)
            }
            binding?.button10?.id -> {
                setPlayerValueAndCallMove(binding?.button10, 1, 0)
            }
            binding?.button11?.id -> {
                setPlayerValueAndCallMove(binding?.button11, 1, 1)
            }


        }
    }


    private fun setPlayerValueAndCallMove(button: Button?, row: Int, col: Int) {
        //move_counter++
        if (isfirstplayer_turn) {
            button?.text = "1"
            isfirstplayer_turn = false
            viewModel.checkWinner(row, col, 1)
        } else {
            button?.text = "2"
            isfirstplayer_turn = true
            viewModel.checkWinner(row, col, 2)

        }


    }



}