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

    //Declaring elements
    private lateinit var playerOneName: EditText
    private lateinit var playerTwoName: EditText
    private lateinit var startGame : Button

    //variables to store text
    private lateinit var getPlayerOne : String
    private lateinit var getPlayerTwo : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initial_view)

        playerOneName = findViewById(R.id.playerOne)
        playerTwoName = findViewById(R.id.playerTwo)
        startGame = findViewById(R.id.startGame)

        getPlayerOne = ""
        getPlayerTwo = ""

        if(savedInstanceState != null){
            getPlayerOne = savedInstanceState.getString("Player One Name", "")
            getPlayerTwo = savedInstanceState.getString("Player Two Name", "")
        }


        //event listener in sender button
        startGame.setOnClickListener {

            //get values input convert to string
            getPlayerOne = playerOneName.text.toString()
            getPlayerTwo = playerTwoName.text.toString()

            if (getPlayerOne.isEmpty() || getPlayerTwo.isEmpty()) {
                Toast.makeText(this, "Add players name", Toast.LENGTH_LONG)
                    .show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Player one", getPlayerOne)
                intent.putExtra("Player two", getPlayerTwo)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Player One Name", getPlayerOne)
        outState.putString("Player Two Name", getPlayerTwo)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        getPlayerOne = savedInstanceState.getString("Player One Name",getPlayerOne)
        getPlayerTwo = savedInstanceState.getString("Player Two Name",getPlayerTwo)
    }
}