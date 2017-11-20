package com.fabiocarpinato.whatshouldieat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val options: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selected_food_text.text = selectRandomOption()

        add_food_button.setOnClickListener {
            this.addFoodOption()
            val animation: Animation = AnimationUtils.loadAnimation(add_food_button.context, R.anim.button)
            add_food_button.startAnimation(animation)
        }

        decide_button.setOnClickListener {
            selected_food_text.text = selectRandomOption()
            val animation: Animation = AnimationUtils.loadAnimation(decide_button.context, R.anim.abc_fade_in)
            animation.duration = 1500
            decide_button.startAnimation(animation)
        }
    }

    private fun addFoodOption(): Unit {
        val enteredFood: String = add_food_text_input.text.toString()
        if ( enteredFood.isNotBlank() ) {
            options.add(enteredFood)
        }
    }

    private fun selectRandomOption(): String {
        if ( this.options.isEmpty() ) { return "No food entered" }
        val randomIndex = (Math.random() * this.options.size).toInt()
        return this.options[randomIndex]
    }

}
