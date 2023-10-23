package com.example.hijoputa.heroes

import com.example.hijoputa.heroes.Repositories.HeroRepository

class HeroProvider(private val heroRepository: HeroRepository) {
    suspend fun GetHeroes(offset: Int ,limit: Int) : MutableList<HeroData>{
        return heroRepository.GetHeros(offset, limit)
    }
}