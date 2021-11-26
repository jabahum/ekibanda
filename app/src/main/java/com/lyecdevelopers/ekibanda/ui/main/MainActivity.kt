package com.lyecdevelopers.ekibanda.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.databinding.ActivityMainBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    lateinit var binding: ActivityMainBinding

    override fun getBindingVariable(): Int {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // appbar navigation
        val navController = Navigation.findNavController(this, R.id.main_nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(
            toolbar, navController, appBarConfiguration
        )
    }
}