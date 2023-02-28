package com.example.a4month_dz2.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("key", Context.MODE_PRIVATE)
    }

    var save: Boolean
        set(value) = sharedPreferences.edit().putBoolean("key", value).apply()
        get() = sharedPreferences.getBoolean("key", false)

    var singIn: Boolean
        set(value) = sharedPreferences.edit().putBoolean("kill", value).apply()
        get() = sharedPreferences.getBoolean("kill", false)
}