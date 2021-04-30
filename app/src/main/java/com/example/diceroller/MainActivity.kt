package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class Dice(private val sideNumber: Int) {
    fun roll(): Int {
        return (1..sideNumber).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // Do a dice roll when the app starts
        rollDice()

    }

    private fun whenResource(diceRoll: Int):Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    /**
    * Roll the dice and update the screen with the result.
    */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll1 = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource1 = whenResource(diceRoll1)
        val drawableResource2 = whenResource(diceRoll2)

        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }

}