package com.example.a4month_dz2.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a4month_dz2.fragments.onboard.OnBoardPagingFragment
import com.example.a4month_dz2.fragments.onboard.OnBoardPagingFragment.Companion.ARG_ONBOARD_PAGE_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_PAGE_POSITION, position)
        }
    }
}