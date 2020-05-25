package com.example.fragmentkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FragmentA.newInstance()
            1 -> FragmentB.newInstance()
            2 -> FragmentC.newInstance()
            else -> FragmentA.newInstance()
        }
    }
}