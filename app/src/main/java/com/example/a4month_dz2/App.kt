package com.example.a4month_dz2

import android.app.Application
import com.example.a4month_dz2.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initPref()
    }

    private fun initPref() {
        PreferenceHelper.unit(this)
    }
}