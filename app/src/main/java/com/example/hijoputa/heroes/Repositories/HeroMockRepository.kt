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

    override suspend fun GetHeros(offset: Int ,limit: Int): MutableList<HeroData> {

        if(heroListMonk.size<=offset){
            return mutableListOf()
        }

        if(heroListMonk.size<=offset + limit){
            return  heroListMonk.subList(offset,heroListMonk.size - 1)
        }

        return heroListMonk.subList(offset, offset + limit);
    }


}