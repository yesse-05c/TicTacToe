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

    private fun checkCols(): Boolean {
        for(col in 0 until 3){
            if(tictactoeArray[0][col] == tictactoeArray[1][col] && tictactoeArray[1][col] == tictactoeArray[2][col] && tictactoeArray[0][col] != 0){
                return true
            }
        }
        return false
    }

    private fun checkRows(): Boolean {
        for(row in 0 until 3){
            if(tictactoeArray[row][0] == tictactoeArray[row][1] && tictactoeArray[row][1] == tictactoeArray[row][2] && tictactoeArray[row][0] != 0){
                return true
            }
        }
        return false
    }

    private fun checkDiagonal(): Boolean {
        return(tictactoeArray[0][0] == tictactoeArray[1][1] && tictactoeArray[1][1] == tictactoeArray[2][2] && tictactoeArray[0][0] != 0) ||
                (tictactoeArray[0][2] == tictactoeArray[1][1] && tictactoeArray[1][1] == tictactoeArray[2][0] && tictactoeArray[0][2] != 0)
    }

    private fun isBoardFull(): Boolean {
        for (row in 0 until 3){
            for (col in 0 until 3){
                if (tictactoeArray[row][col] == 0){
                    return false
                }
            }
        }
        return true
    }

    fun getCurrentPlayer() : Int{
        return currentPlayer
    }
    fun getGameBoard() : Array<IntArray>{
        return tictactoeArray
    }
    fun resetGame(){
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                tictactoeArray[i][j] = 0
            }
        }
        currentPlayer = 1
    }
}