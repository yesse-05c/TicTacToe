package com.zybooks.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getplayerOne = getIntent().getStringExtra("Player One Name")
        val getplayerTwo = getIntent().getStringExtra("Player Two Name")

        val playerOneName = findViewById<TextView>(R.id.playerOneTextview)
        val playerTwoName = findViewById<TextView>(R.id.playerTwoTextview)

        playerOneName.text = "$getplayerOne"
        playerTwoName.text = "$getplayerTwo"
    }
}