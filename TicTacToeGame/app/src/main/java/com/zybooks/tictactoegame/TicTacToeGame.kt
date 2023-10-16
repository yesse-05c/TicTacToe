package com.zybooks.tictactoegame

const val GRID_SIZDE = 3
class TicTacToeGame {

    private val tictactoeArray = Array(GRID_SIZDE){ IntArray(GRID_SIZDE)}
    private var currentPlayer = 1

    fun makeMove(row :Int, col : Int): Boolean{
        if (tictactoeArray[row][col] == 0){
            tictactoeArray[row][col] = currentPlayer
            currentPlayer = if(currentPlayer == 1) 2 else 1
            return true
        }
        return false
    }

    fun checkForWins() : Int{
        if(checkRows() || checkCols() || checkDiagonal()){
            //find winner X = 1 or O = 2
            return if(currentPlayer == 1) 1 else 2
        }
        if(isBoardFull()){
            //draw
            return 3
        }
        return 0 //still playing. Able to make moves
    }

    private fun isBoardFull(): Boolean {
        return true
    }

    private fun checkDiagonal(): Boolean {
        return true
    }

    private fun checkCols(): Boolean {
        return true
    }

    private fun checkRows(): Boolean {
        return true
    }
    fun getCurrentPlayer() : Int{
        return currentPlayer
    }
    fun getGameBoard() : Array<IntArray>{
        return tictactoeArray
    }

}