package com.lyecdevelopers.ekibanda.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.databinding.ActivityMainBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseActivity
/**
 * created by jaba
 * */
class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var toolBar: Toolbar

    override fun getBindingVariable(): Int {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseViews()

        // appbar navigation
        setupAppBar()
        // bottom navigation
        setUpNavigation()
    }

    private fun initialiseViews() {
        navController = Navigation.findNavController(this, R.id.main_nav_host_fragment)
        toolBar = findViewById(R.id.toolbar)
    }

    private fun setupAppBar() {
        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        setSupportActionBar(toolBar)
        NavigationUI.setupWithNavController(
            toolBar, navController, appBarConfiguration
        )
    }

    private fun setUpNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)
    }
}