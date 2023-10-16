package com.zybooks.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayout : GridLayout
    private lateinit var ticTacToeGame : TicTacToeGame

    //Key constants for saving and restoring state
    private val PLAYER_KEY = "currentPlayer"
    private val GAME_BOARD = "gameBoard"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playerOneName = findViewById<TextView>(R.id.playerOneTextview)
        var playerTwoName = findViewById<TextView>(R.id.playerTwoTextview)
        gridLayout = findViewById(R.id.gridLayout)
        ticTacToeGame = TicTacToeGame()

        //Displaying player's name
        val intent = intent
        val getplayerOne = intent.getStringExtra("Player one")
        val getplayerTwo = intent.getStringExtra("Player two")

        playerOneName.text = getplayerOne
        playerTwoName.text = getplayerTwo

        //Each button click listener event
        for(i in 1..9){
            val box = findViewById<Button>(resources.getIdentifier("box$i", "id", packageName))
            box.setOnClickListener(){
                onButtonClick(i -1,box)
            }
        }

    }

    private fun onButtonClick(index : Int, button : Button) {
        val row = index / 3
        val col = index % 3
        if (ticTacToeGame.makeMove(row, col)){
            val currentPlayer = ticTacToeGame.getCurrentPlayer()
            val moveImage = if(currentPlayer == 1) R.drawable.zero else R.drawable.pngwing
            button.setBackgroundResource(moveImage)

            val result = ticTacToeGame.checkForWins()
            when(result){
                1 -> {
                    //needs to be updated in a winner function to be displayed on the textView
                    //Toast.makeText(this, "Player 1 (X) wins!", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    //Toast.makeText(this, "Player 2 (O) wins!", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    //Toast.makeText(this, "It's a draw", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}