package com.zybooks.tictactoegame

import android.app.GameState
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InitialActivity : AppCompatActivity() {

    private lateinit var playerOneName: EditText
    private lateinit var playerTwoName: EditText
    private lateinit var startGame : Button
    private lateinit var getPlayerOne : String
    private lateinit var getPlayerTwo : String
    private lateinit var gameState : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initial_view)

        playerOneName = findViewById(R.id.playerOne)
        playerTwoName = findViewById(R.id.playerTwo)
        startGame = findViewById(R.id.startGame)

        startGame.setOnClickListener {
            getPlayerOne = playerOneName.getText().toString()
            getPlayerTwo = playerTwoName.getText().toString()

            if (getPlayerOne.isEmpty() || getPlayerTwo.isEmpty()) {
                Toast.makeText(this, "Add players name", Toast.LENGTH_LONG)
                    .show()
            } else {
                gameState = "Game State here"
                val intent: Intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Player one", getPlayerOne)
                intent.putExtra("Player Two", getPlayerTwo)
                intent.putExtra("Game State", gameState)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Player One Name", getPlayerOne)
        outState.putString("Player Two Name", getPlayerTwo)
        outState.putString("Game state", gameState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        getPlayerOne = savedInstanceState.getString("Player One Name",getPlayerOne)
        getPlayerTwo = savedInstanceState.getString("Player Two Name",getPlayerTwo)
        gameState = savedInstanceState.getString("Game state", gameState)
    }
}