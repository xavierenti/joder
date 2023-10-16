package com.example.apuntesclase

import android.content.Context
import android.graphics.Path.Op
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.hijoputa.R
import com.example.hijoputa.SharedPreferencesManager

class MainActivity : ComponentActivity() {

    val openTimesText : TextView by lazy {findViewById(R.id.open_app_text)}

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
/*
        val shared = this.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)

        var timesOpenApp = shared.getInt("appOpenTimes", 0)

        val editor = shared.edit()

        editor.putInt("appOpenTimes", timesOpenApp)
        editor.apply()
*/
        SharedPreferencesManager.TimesOpenApp++
        openTimesText.text = SharedPreferencesManager.TimesOpenApp.toString()

    }
}
