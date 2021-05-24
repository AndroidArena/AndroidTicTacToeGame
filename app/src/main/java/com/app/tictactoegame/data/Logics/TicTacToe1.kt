package com.app.tictactoegame.data.Logics

import javax.inject.Inject


/** Player {player} makes a move at ({row}, {col}).
 * @param row The row of the board.
 * @param col The column of the board.
 * @param player The player, can be either 1 or 2.
 * @return The current winning condition, can be either:
 * 0: No one wins.
 * 1: Player 1 wins.
 * 2: Player 2 wins.
 *
 * In all winner checking functions we are also returning -1 for local reference if condition is not satisfied then move to next check inside move()
 */

class TicTacToe1 @Inject constructor() : TicTacToeHelper {

    private lateinit var matrix: Array<IntArray>
    private var player_won = 0

    fun initializeBoard(n: Int) {
        matrix = Array(n) { IntArray(n) }
    }

    fun move(row: Int, col: Int, player: Int): Int {

        val winner_alreadymade = checkIfWinnerIsAlreadyAnnouced()
        if (winner_alreadymade > 0) return winner_alreadymade

        fillBoardWithPlayerValue(row, col, player)

        val winner_rowwise = checkWinnerRowWise(row, player)
        if (winner_rowwise > 0) return winner_rowwise

        val winner_columnwise = checkWinnerColumnWise(col, player)
        if (winner_columnwise > 0) return winner_columnwise

        val winner_forward_Dignalwise = checkWinnerForwardDiagnoalWise(player)
        if (winner_forward_Dignalwise > 0) return winner_forward_Dignalwise

        return checkWinnerBackwordDiagnalWise(player)
    }

    private fun checkIfWinnerIsAlreadyAnnouced(): Int {
        if (player_won > 0) {
            return player_won
        }
        return -1
    }

    private fun fillBoardWithPlayerValue(row: Int, column: Int, player: Int) {
        matrix[row][column] = player
    }

    override fun checkWinnerRowWise(row: Int, player: Int): Int {
        var win = true
        for (i in matrix.indices) {
            if (matrix[row][i] != player) {
                win = false
                break
            }
        }
        if (win) {
            player_won = player
            return player
        }
        return -1
    }

    override fun checkWinnerColumnWise(column: Int, player: Int): Int {
        var win = true
        for (i in matrix.indices) {
            if (matrix[i][column] != player) {
                win = false
                break
            }
        }
        if (win) {
            player_won = player
            return player
        }
        return -1
    }

    override fun checkWinnerForwardDiagnoalWise(player: Int): Int {
        //check back diagonal top left->right bottom

        var win = true
        for (i in matrix.indices) {
            if (matrix[i][i] != player) {
                win = false
                break
            }
        }
        if (win) {
            player_won = player
            return player
        }
        return -1
    }

    override fun checkWinnerBackwordDiagnalWise(player: Int): Int {
        //check forward diagonal  TOP right --> bottom left

        var win = true
        for (i in matrix.indices) {
            if (matrix[i][matrix.size - i - 1] != player) {
                win = false
                break
            }
        }
        player_won = if (win) player else 0
        return if (win) player else 0
    }

    fun getFinalResults(): Int {
        return player_won
    }

}