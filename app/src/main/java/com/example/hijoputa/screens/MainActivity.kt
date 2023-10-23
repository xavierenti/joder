package com.example.hijoputa.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hijoputa.R
import com.example.hijoputa.heroes.HeroAdapter
import com.example.hijoputa.heroes.HeroData
import com.example.hijoputa.heroes.HeroProvider
import com.example.hijoputa.heroes.Repositories.HeroApiService
import com.example.hijoputa.heroes.Repositories.HeroMockRepository
import com.example.hijoputa.heroes.Repositories.HeroSharedDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val table by lazy { findViewById<RecyclerView>(R.id.my_recycleView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)
        table.adapter = HeroAdapter(HeroApiService())
    }
}
