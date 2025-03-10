package com.liehan.numberguesser

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end of ViewCompat

        //create a random number
        val randomNumber = Random.nextInt(1, 11)

        //connect tge backend to the frontend elements
        val userGuess = findViewById<EditText>(R.id.edtUserGuess)
        val tvAnswer = findViewById<TextView>(R.id.tvAnswer)
        val guessButton = findViewById<Button>(R.id.btnGuess)

        //creates the button listener or click action
        guessButton.setOnClickListener {
            //get the user guess from the element and saves it into a variable
            var guessNumberString = userGuess.text.toString()
            //creates an empty integer variable
            var guessNumberInt: Int
            when {
                //checks if the guess is a number
                guessNumberString.toIntOrNull() != null -> {
                    //if yes, converts the guess to an integer
                    guessNumberInt = guessNumberString.toInt()
                    //check guess against random number
                    if (guessNumberInt == randomNumber) {
                        //if yes, displays a toast message
                        Toast.makeText(this, "You guessed correctly", Toast.LENGTH_SHORT).show()
                    } else {
                        //if no, displays a toast message
                        Toast.makeText(this, "You guessed incorrectly", Toast.LENGTH_SHORT).show()
                    }
                    //sets the tvAnswer to the random number if the guess was a number
                    tvAnswer.text = randomNumber.toString()
                }
                //if guess was not a number, displays a toast message
                else -> {
                    Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                } //end of else
            } //end of when
        } //end of guessButton.setOnClickListener
    } //end of onCreate
} //end of Main