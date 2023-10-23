package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.Shared
import com.example.hijoputa.heroes.HeroData

class HeroSharedDatabase :HeroRepository {
    override suspend fun GetHeros(): MutableList<HeroData> {
        return Shared.heroes
    }

}