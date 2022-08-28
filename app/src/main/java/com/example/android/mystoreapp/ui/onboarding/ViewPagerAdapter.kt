package com.example.android.mystoreapp.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
fragmentList: List<Fragment>) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private var myList = fragmentList

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun createFragment(position: Int): Fragment {
        return myList[position]
    }
}