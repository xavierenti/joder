package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.Shared
import com.example.hijoputa.heroes.HeroData

class HeroSharedDatabase :HeroRepository {
    override suspend fun GetHeros(offset: Int ,limit: Int): MutableList<HeroData> {

        val heroes = Shared.heroes

        if(heroes.size<=offset){
            return mutableListOf()
        }

        if(heroes.size<= offset+limit){
            return heroes.subList(offset,heroes.size - 1)
        }

        return Shared.heroes.subList(offset,offset + limit)
    }

}