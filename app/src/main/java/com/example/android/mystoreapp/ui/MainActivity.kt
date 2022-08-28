package com.example.android.mystoreapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: Fragment
    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navHostFragment.findNavController()
        return navController.navigateUp(appBarConfiguration)
    }

}