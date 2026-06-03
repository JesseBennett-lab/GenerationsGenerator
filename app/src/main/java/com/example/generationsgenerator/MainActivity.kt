package com.example.generationsgenerator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val birthYearEditText = findViewById<EditText>(R.id.birthYearEditText)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val displayTextView = findViewById<TextView>(R.id.displayTextView)

        val year = birthYearEditText.text.toString().toInt()
        val generation = when (year) {
            in 1928..1945 -> "Silent Generation"
            in 1946..1964 ->  "Baby Boomer"
            in 1965..1980 -> "Gen X"
            in 1981..1996 -> "Millennial"
            in 1997..2012 -> "Gen Z"
            in 2013..2024 -> "Gen Alfa"
            else -> "Unknown generation"
        }
        displayTextView.text = "Your generation: $generation"












        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}