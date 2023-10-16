package com.example.hijoputa.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.hijoputa.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy { findViewById<Button>(R.id.bt_change_screen) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener{
            val newIntent = Intent(this, SecondScreen::class.java)
            newIntent.putExtra("textString", "cadena de texto transferida")

            this .startActivity (newIntent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
        }
    }
}
