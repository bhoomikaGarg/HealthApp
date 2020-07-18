package com.example.healthapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.healthapp.R
import com.example.healthapp.fragments.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var frameLayout:FrameLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navigationView: NavigationView

    var previousMenuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        frameLayout = findViewById(R.id.frame)
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        setUpToolbar()


        openHome()
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem!=null){
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId) {
                R.id.home ->{
                    supportFragmentManager.beginTransaction()
                        openHome()
                    drawerLayout.closeDrawers()

                }
                R.id.gymWorkout ->{
                    supportFragmentManager.beginTransaction()
                        openGym()
                    drawerLayout.closeDrawers()
                }
                R.id.yoga ->{
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            YogaFragment()
                        )
                        .commit()
                    supportActionBar?.title = "Yoga Workout"
                    drawerLayout.closeDrawers()
                }
                R.id.dimensionOfWellness ->{
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            DimensionOfWellnessFragment()
                        ).commit()
                    supportActionBar?.title = "Dimensions Of Wellness"
                    drawerLayout.closeDrawers()
                }
                R.id.aboutapp ->{
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame,
                        AboutAppFragment()
                    )

                    .commit()

                supportActionBar?.title = "About app"
                drawerLayout.closeDrawers()
            }

            }
            return@setNavigationItemSelectedListener true

        }

}
    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openHome(){
        val fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            HomeFragment()
        )   // dashboard fragment is replacing the blank frame
        transaction.commit()
        supportActionBar?.title = "Health And Wellness"    //giving the title to each fragment
        navigationView.setCheckedItem(R.id.home)
    }
    fun openGym(){
        val fragment = GymFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            GymFragment()
        )   // dashboard fragment is replacing the blank frame
        transaction.commit()
        supportActionBar?.title = "Gym Workout"    //giving the title to each fragment
        navigationView.setCheckedItem(R.id.gymWorkout)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            is GymFragment -> openHome() // if at any frame ie other than dashboard this will bring back to dasboard on pressing back key
            is YogaFragment -> openHome()
            is AboutAppFragment -> openHome()
            is DimensionOfWellnessFragment -> openHome()


            is Gym_routine_advance -> openGym()
            is Gym_routine_beginner -> openGym()
            is Gym_routine_intermediate -> openGym()

            else -> super.onBackPressed()     // Exit the app (default)
        }
    }

}