package com.ardianeffendi.academy.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ardianeffendi.academy.ui.academy.AcademyFragment
import com.ardianeffendi.academy.ui.bookmark.BookmarkFragment

class SectionsPagerAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> AcademyFragment()
            1 -> BookmarkFragment()
            else -> Fragment()
        }


    override fun getItemCount(): Int = 2
}