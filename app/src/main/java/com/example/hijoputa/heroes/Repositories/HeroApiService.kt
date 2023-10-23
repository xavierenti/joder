package com.example.hijoputa.heroes.Repositories

import com.example.hijoputa.heroes.HeroData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class HeroApiService : HeroRepository {

    companion object{
        const val BASE_URL = "https://gateway.marvel.com:433/v1/public/"
        const val API_KEY = "11be8f553f6745bbb19124184437244e"
        const val PRIVATE_KEY = "ebcd089471082ec89e138c9855994a33517c0a33"

        val TimesStamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash : String get(){
            val input : String = "$TimesStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            val finalHash = BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')

            return finalHash
        }

        val apiService : RetrofitHeroApiService by lazy{
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitHeroApiService::class.java)
        }

    }

    interface RetrofitHeroApiService{
        @GET("characters")
        suspend fun GetHeroes(
            @Query("ts") timeStamp : String = TimesStamp,
            @Query("apiKey") apiKey : String = API_KEY,
            @Query("hash") hash : String = Hash,
            @Query("offset") offset :Int,
            @Query("limit") limit : Int
        ): Response<CharactersResponse>
    }

    override suspend fun GetHeros(offset: Int ,limit: Int): MutableList<HeroData> {

        val response = apiService.GetHeroes(offset = offset, limit = limit)

        if(response.isSuccessful){

            response.body()?.data?.results?.let {heroes->
                return heroes
            }?:run{
                //Gestionar aviso de que no ha recibido los datos
                return mutableListOf()
            }
        }else {
            //Gestionar aviso de que no ha funcionado
            return mutableListOf()
        }

    }
}