package com.example.bitecheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set toolbar sebagai ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))

        // ambil NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Tentukan top-level destinations (fragment utama)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_dashboard,
                R.id.nav_account,
                R.id.nav_reminders,
                R.id.nav_reports,
                R.id.nav_feedback,
                R.id.nav_settings,
                R.id.nav_logout,
                R.id.nav_daily_goals,
                R.id.nav_weight_tracker,
                R.id.nav_water_tracker,
                R.id.nav_ai_chat
            ),
            findViewById(R.id.drawer_layout) // kalau ada drawer
        )

        // setup ActionBar (title + back button)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // hubungkan Navigation Drawer (jika ada)
        findViewById<NavigationView>(R.id.nav_view)?.setupWithNavController(navController)

        // hubungkan Bottom Navigation
        findViewById<BottomNavigationView>(R.id.bottom_nav)?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
