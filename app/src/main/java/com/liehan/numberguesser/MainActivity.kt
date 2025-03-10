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

        //get the user guess and save it as an int
        val userGuess = findViewById<EditText>(R.id.edtUserGuess)
        val tvAnswer = findViewById<TextView>(R.id.tvAnswer)
        val guessButton = findViewById<Button>(R.id.btnGuess)
        guessButton.setOnClickListener {
            var guessNumberString = userGuess.text.toString()
            var guessNumberInt: Int
            when {
                guessNumberString.toIntOrNull() != null -> {
                    guessNumberInt = guessNumberString.toInt()

                    //check guess against random number
                    if (guessNumberInt == randomNumber) {
                        Toast.makeText(this, "You guessed correctly", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "You guessed incorrectly", Toast.LENGTH_SHORT).show()
                    }
                    //sets the tvAnswer to the random number
                    tvAnswer.text = randomNumber.toString()
                }
                else -> {
                    Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    } //end of onCreate
} //end of Main