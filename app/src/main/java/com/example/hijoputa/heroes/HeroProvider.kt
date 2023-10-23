package com.example.hijoputa.heroes

import com.example.hijoputa.heroes.Repositories.HeroRepository

class HeroProvider(private val heroRepository: HeroRepository) {
    suspend fun GetHeroes() : MutableList<HeroData>{
        return heroRepository.GetHeros()
    }
}