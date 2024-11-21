package com.example.kotlin.examen.utils

import android.app.Application
import android.util.Log
import com.example.kotlin.examen.data.network.NetworkModuleDI

class Examen : Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkModuleDI.initializeParse(this)
        Log.d("Examen", "Parse inicializado")
    }
}
