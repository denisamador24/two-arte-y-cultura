package com.example.arteycultura

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer : DrawerLayout
    private lateinit var toggle : ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val toolBar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar_main)
       // setSupportActionBar(toolBar) //Aqui esta el error


        drawer = findViewById(R.id.drawer_layout)
       /* val navHeaderCardView = findViewById<CardView>(R.id.nav_header_CardViewProfile)
        navHeaderCardView.setOnClickListener {
            intentProfle()
        } */

        toggle = ActionBarDrawerToggle(this, drawer, toolBar, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.itemIconTintList = null
        navigationView.setNavigationItemSelectedListener(this)


        try {
            replaceFragment(HomeFragment(), "Home")
        }catch (ex: Exception){
            Toast.makeText(this, "Error: $ex", Toast.LENGTH_LONG).show()
        }
    }

    fun intentProfle (){
        intent = Intent(this, MyProfileActivity::class.java)
        startActivity(intent)
    }

    private fun replaceFragment (fragment: Fragment, title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_activity_fragment, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        try {
            when (item.itemId) {
                R.id.nav_item_one -> replaceFragment(BandaFragment(), item.title.toString())
                R.id.nav_item_two -> replaceFragment(DanceFragment(), item.title.toString())
                R.id.nav_item_three -> replaceFragment(PaintFragment(), item.title.toString())
                R.id.nav_item_four -> replaceFragment(CraftsmanFragment(), item.title.toString())
                R.id.nav_item_profile -> {
                    val intent = Intent(this, MyProfileActivity::class.java)
                    startActivity(intent)
                }
                else -> Toast.makeText(this, "Fragment no encontrado", Toast.LENGTH_SHORT).show()
            }
        }catch (ex: Exception){
            Toast.makeText(this, "Error: $ex", Toast.LENGTH_LONG).show()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}