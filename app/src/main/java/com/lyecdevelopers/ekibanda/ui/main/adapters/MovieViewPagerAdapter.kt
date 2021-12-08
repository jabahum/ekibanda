package com.lyecdevelopers.ekibanda.ui.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lyecdevelopers.ekibanda.ui.main.home.movie.CastFragment
import com.lyecdevelopers.ekibanda.ui.main.home.movie.PhotosFragment
import com.lyecdevelopers.ekibanda.ui.main.home.movie.ReviewsFragment

class MovieViewPagerAdapter(fragmentActivity: FragmentActivity, private val size: Int) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return CastFragment()
            1 -> return PhotosFragment()
            2 -> return ReviewsFragment()
        }
        return CastFragment()
    }
}