package com.app.tictactoegame.data.Logics

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


/** Player {player} makes a move at ({row}, {col}).
 * @param row The row of the board.
 * @param col The column of the board.
 * @param player The player, can be either 1 or 2.
 * @return The current winning condition, can be either:
 * 0: No one wins.
 * 1: Player 1 wins.
 * 2: Player 2 wins.
 */

@RunWith (JUnit4::class)
class TicTacToe1Test{

    lateinit var ticTacToe1 :TicTacToe1

    @Before
    fun setup(){
        ticTacToe1 = TicTacToe1()

    }

    @Test
    fun `check winner for 2x2 Board Player 2 Winner`(){
        ticTacToe1.initializeBoard(2)

        ticTacToe1.move(0,0,1)
        ticTacToe1.move(0,1,2)
        ticTacToe1.move(1,0,2)

        assertEquals(ticTacToe1.getFinalResults(),2)
    }

    @Test
    fun `check winner for 3x3 Board Player 1 winner`(){
        ticTacToe1.initializeBoard(3)

        ticTacToe1.move(0,0,1)
        ticTacToe1.move(1,0,2)
        ticTacToe1.move(0,1,1)
        ticTacToe1.move(1,1,2)
        ticTacToe1.move(0,2,1)

        assertEquals(ticTacToe1.getFinalResults(),1)
    }

    @Test
    fun `check winner for 3x3 Board Match Draw`(){
        ticTacToe1.initializeBoard(3)

        ticTacToe1.move(0,0,1)
        ticTacToe1.move(1,0,2)
        ticTacToe1.move(0,1,1)
        ticTacToe1.move(1,1,2)
        ticTacToe1.move(1,2,1)
        ticTacToe1.move(0,2,2)
        ticTacToe1.move(2,0,1)

        assertEquals(ticTacToe1.getFinalResults(),0)
    }

    @After
    fun tear(){

    }



}