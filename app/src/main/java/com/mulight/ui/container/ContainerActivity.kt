package com.mulight.ui.container

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mulight.R
import kotlinx.android.synthetic.main.activity_container.*

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar)


        Navigation.findNavController(this, R.id.nav_host_fragment)
            .addOnDestinationChangedListener { _, destination: NavDestination, _ ->
                toolbarTitle.text = destination.label
            }
        NavigationUI.setupWithNavController(
            toolbar,
            Navigation.findNavController(this, R.id.nav_host_fragment)
        )
    }
}
