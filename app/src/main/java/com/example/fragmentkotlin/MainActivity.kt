package com.example.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_a.*

class MainActivity : AppCompatActivity()  {

    val pageTransformer = PageTransformer()

private var selectedFragment: Fragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft.setOnClickListener {
            buttonNav()
        }
        btnRight.setOnClickListener {
            buttonNav()
        }
        val marginPageTransformer = MarginPageTransformer(50)

        viewPager2.adapter = ViewPagerAdapterFragmentStateAdapter(this)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager()
    }

    private fun viewPager(){
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                when(position){
//                    0 -> {bottomNav.menu.findItem(R.id.menu_home).isChecked = true
//                        selectedFragment = FragmentA()
//                        buttonNav()
//                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
//                    1 -> {bottomNav.menu.findItem(R.id.menu_notification).isChecked = true
//                        selectedFragment = FragmentB()
//                        buttonNav()
//                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
//                    2 -> {bottomNav.menu.findItem(R.id.menu_search).isChecked = true
//                        selectedFragment = FragmentC()
//                        buttonNav()
//                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
//                }
//            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when(position){
                    0 -> {bottomNav.menu.findItem(R.id.menu_home).isChecked = true
                        selectedFragment = FragmentA()
                        buttonNav()
                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
                    1 -> {bottomNav.menu.findItem(R.id.menu_notification).isChecked = true
                        selectedFragment = FragmentB()
                        buttonNav()
                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
                    2 -> {bottomNav.menu.findItem(R.id.menu_search).isChecked = true
                        selectedFragment = FragmentC()
                        buttonNav()
                        supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()}
                }
            }
        })
    }

    fun buttonNav(){
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home ->{
                    title = "FragmentA"
                    selectedFragment = FragmentA()
                    viewPager2.setPageTransformer(pageTransformer)
                    true
                }
                R.id.menu_notification -> {
                    title = "FragmentB"
                    selectedFragment = FragmentB()
                    true
                }
                R.id.menu_search -> {
                    title = "FragmentC"
                    selectedFragment = FragmentC()
                    true
                }
                else -> false
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment,selectedFragment).commit()
            return@setOnNavigationItemSelectedListener true
        }
    }
}
