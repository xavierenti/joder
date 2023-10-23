package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.heroes.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(@SerializedName("code") val SerializedName: String, val data: CharactersResponseData)

data class CharactersResponseData(val total: Int, val count: Int, val results: MutableList<HeroData>)