package com.example.hijoputa.heroes

class HeroProvider {
    companion object{
        private val heroList = listOf(
            HeroData("Puton","Se las come todas"),
            HeroData("Cabron","Solo necesita un cabezazo"),
            HeroData("descgraciado","te hace la vida impossible")
        )
        fun GetAllHeros() : List<HeroData> = heroList
    }
}