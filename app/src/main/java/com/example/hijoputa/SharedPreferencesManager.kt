package com.example.hijoputa

import android.content.Context
import android.content.SharedPreferences

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {

    private const val MyAppPreferencesName= "MySharedPreferences"

    private const val AppOpenTimesKey = "AppOpenTimes"

    private val shared : SharedPreferences by lazy{MyApp.context.getSharedPreferences(
        MyAppPreferencesName,Context.MODE_PRIVATE)}
    private val editor: SharedPreferences.Editor by lazy {shared.edit()}

    public var TimesOpenApp: Int
        get() = shared.getInt(AppOpenTimesKey,0)
        set(newValue){
            editor.putInt(AppOpenTimesKey,newValue)
            editor.apply()
        }
}