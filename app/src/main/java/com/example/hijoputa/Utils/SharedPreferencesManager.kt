package com.example.hijoputa.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.hijoputa.MyApp
import com.example.hijoputa.heroes.HeroData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONStringer

object SharedPreferencesManager {

    private const val MyAppPreferencesName= "MySharedPreferences"

    private const val AppOpenTimesKey = "AppOpenTimes"

    private val shared : SharedPreferences by lazy{
        MyApp.context.getSharedPreferences(
        MyAppPreferencesName, Context.MODE_PRIVATE
        )}
    private val editor: SharedPreferences.Editor by lazy {shared.edit()}

    public var TimesOpenApp: Int
        get() = shared.getInt(AppOpenTimesKey,0)
        set(newValue){
            editor.putInt(AppOpenTimesKey,newValue)
            editor.apply()
        }

    private const val HeroesKey = "Heroes"
    public var heroes : MutableList<HeroData>
        get(){
            val jsonString = shared.getString(HeroesKey,"")
            val listType = object : TypeToken<MutableList<HeroData>?>() {}.type
            val heroList = Gson().fromJson<MutableList<HeroData>?>(jsonString,listType)

            if(heroList == null)
                return mutableListOf()

            return heroList
        }

        set(value){
            val jsonString = Gson().toJson(value)
            editor.putString(HeroesKey, jsonString)
            editor.apply()
        }
}