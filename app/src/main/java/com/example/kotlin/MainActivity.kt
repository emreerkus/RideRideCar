package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private val drawerLayout: DrawerLayout by lazy{
        findViewById(R.id.drawerLayout)
    }
    private val navController by lazy {
        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.findNavController()
    }

    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.mainFragment, R.id.profileFragment), drawerLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawerLayout()
    }

    private fun setupDrawerLayout(){
        val navigationView: NavigationView = findViewById(R.id.navView)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}


