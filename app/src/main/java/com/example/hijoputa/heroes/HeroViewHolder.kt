package com.example.hijoputa.heroes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hijoputa.R

class HeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val name by lazy { view.findViewById<TextView>(R.id.Hero_cell_title) }
    val description by lazy { view.findViewById<TextView>(R.id.Hero_cell_description) }
    var heroState : heroData?

    fun SetUpCellWithHero(hero : HeroData){
        name.text = hero.name
        description.text = hero.descriptor
    }
}