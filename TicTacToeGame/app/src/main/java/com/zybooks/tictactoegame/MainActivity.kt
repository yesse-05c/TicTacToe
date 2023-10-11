package com.zybooks.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playerOneName = findViewById<TextView>(R.id.playerOneTextview)
        var playerTwoName = findViewById<TextView>(R.id.playerTwoTextview)

        val intent = intent

        val getplayerOne = intent.getStringExtra("Player one")
        val getplayerTwo = intent.getStringExtra("Player two")

        playerOneName.text = getplayerOne
        playerTwoName.text = getplayerTwo
    }
}