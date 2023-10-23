package com.example.hijoputa.heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hijoputa.R
import com.example.hijoputa.heroes.Repositories.HeroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HeroAdapter(private val repository:HeroRepository, private val pagination : Int = 20): RecyclerView.Adapter<HeroViewHolder>() {

    private var heroList :MutableList<HeroData> = mutableListOf()
    private val provider: HeroProvider = HeroProvider(repository)
    private var requestingData: Boolean = false

    init{
        getMoreHeroes()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetUpCellWithHero(heroList[position])

        if(position >= heroList.size - pagination){
            getMoreHeroes()
        }
    }

    private fun getMoreHeroes(){
        if(requestingData )
            return

        requestingData = true

        CoroutineScope(Dispatchers.IO).launch{
            var extraHeroes=provider.GetHeroes(heroList.size, pagination)

            heroList.addAll(extraHeroes)
            notifyDataSetChanged()
            requestingData= false
        }
    }
}