package com.example.hijoputa

import android.app.Application

class MyApp:Application() {
    companion object{
        private lateinit var instance :MyApp
        public val context : MyApp get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}