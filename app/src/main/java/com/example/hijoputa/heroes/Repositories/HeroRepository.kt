package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.heroes.HeroData

interface HeroRepository {

    suspend fun GetHeros(offset: Int ,limit: Int) : MutableList<HeroData>
}