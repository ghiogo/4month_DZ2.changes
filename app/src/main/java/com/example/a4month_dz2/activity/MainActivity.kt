package com.example.a4month_dz2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.a4month_dz2.R
import com.example.a4month_dz2.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onStart() {
        super.onStart()
        if (PreferenceHelper.save) {
            navController.navigate(R.id.homeFragment)
        } else {
            navController.navigate(R.id.onBoardFragment)
        }
    }
}