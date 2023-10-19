package com.zybooks.tictactoegame
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import android.widget.Button

const val GRID_SIZE = 3
@Parcelize
class TicTacToeGame : Parcelable  {

    private val tictactoeArray = Array(GRID_SIZE){ IntArray(GRID_SIZE)}
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
        for(col in 0 until GRID_SIZE){
            if(tictactoeArray[0][col] == tictactoeArray[1][col] && tictactoeArray[1][col] == tictactoeArray[2][col] && tictactoeArray[0][col] != 0){
                return true
            }
        }
        return false
    }

    private fun checkRows(): Boolean {
        for(row in 0 until GRID_SIZE){
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
        for (row in 0 until GRID_SIZE){
            for (col in 0 until GRID_SIZE){
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
        for (i in 0 until GRID_SIZE) {
            for (j in 0 until GRID_SIZE) {
                tictactoeArray[i][j] = 0
            }
        }
        currentPlayer = 1
    }

    fun updateUIFromGameBoard(buttons: List<Button>){
        for(row in 0 until GRID_SIZE) {
            for (col in 0 until GRID_SIZE) {
                val index = row * GRID_SIZE + col
                val cellValue = tictactoeArray[row][col]

                //assigning to the buttons on the grid
                val button = buttons[index]

                when(cellValue){
                    1-> button.setBackgroundResource(R.drawable.pngwing) //Assigning X
                    2-> button.setBackgroundResource(R.drawable.zero) //Assigning 0
                    else -> button.setBackgroundResource(R.drawable.box_bg)
                }

            }
        }
    }
}