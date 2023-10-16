package com.example.hijoputa.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.hijoputa.R

class SecondScreen : ComponentActivity() {

    val backButton by lazy {findViewById<ImageButton>(R.id.back_bt)}
    val secondText by lazy { findViewById<TextView>(R.id.secondary_screen_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        backButton.setOnClickListener{
            finish()
        }

        secondText.text = intent.getStringExtra("textString")
    }
}