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

        InitHeroRecycleView()
    }


    private fun InitHeroRecycleView(){
        table.layoutManager = LinearLayoutManager(this)


        val tempList = mutableListOf<HeroData>(
            HeroData("Test 1","Desc"),
            HeroData("Test 1","Desc"),
            HeroData("Test 1","Desc"),
            HeroData("Test 1","Desc")
        )

        //Obtenemos la lista de heroes
        //añadimos un nuebo heroe a la lista
        CoroutineScope ( Dispatchers.IO).launch{
            val heroRepository = HeroSharedDatabase()//nuevo repo
            val provider = HeroProvider(heroRepository)
            val heroList = provider.GetHeroes()
            val adapter = HeroAdapter(heroList)

            CoroutineScope(Dispatchers.Main).launch{
                table.adapter=adapter
            }
        }

        val hero = HeroData("","")
    }
}
