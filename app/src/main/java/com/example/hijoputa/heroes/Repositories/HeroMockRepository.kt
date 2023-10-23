package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.heroes.HeroData

class HeroMockRepository: HeroRepository {

    companion object{
        private val heroListMonk = mutableListOf<HeroData>(
            HeroData("Puton","Se las come todas"),
            HeroData("Cabron","Solo necesita un cabezazo"),
            HeroData("descgraciado","te hace la vida impossible")
        )
    }

    override suspend fun GetHeros(): MutableList<HeroData> {
        return heroListMonk;
    }


}