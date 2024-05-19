package com.example.mahawanti2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class FruitSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_selection)

        val fruits = listOf("apple", "banana", "grapes", "lichi")
        val selectedFruits = mutableListOf<String>()

        val linearLayout = findViewById<LinearLayout>(R.id.fruit_list)
        for (fruit in fruits) {
            val checkBox = CheckBox(this)
            checkBox.text = fruit
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedFruits.add(fruit)
                } else {
                    selectedFruits.remove(fruit)
                }
            }
            linearLayout.addView(checkBox)
        }

        val button = findViewById<Button>(R.id.submit_button)
        button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putStringArrayListExtra("selectedFruits", ArrayList(selectedFruits))
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
