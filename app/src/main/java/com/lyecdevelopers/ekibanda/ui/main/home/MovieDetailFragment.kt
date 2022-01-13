package com.lyecdevelopers.ekibanda.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.databinding.MoviedetailFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.adapters.MovieViewPagerAdapter
import com.lyecdevelopers.ekibanda.utils.CommonUtils
import javax.inject.Inject

class MovieDetailFragment : BaseFragment<MoviedetailFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: MoviedetailFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    private lateinit var movieItem: MovieItem

    var titles = arrayOf("Cast", "Photos")

    override fun getViewModel(): HomeViewModel {
        homeViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.moviedetail_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {
        if (arguments != null) {
            val selectedMovieItem = requireArguments().getString("movie")
            movieItem = CommonUtils.gsonParser!!.fromJson(selectedMovieItem, MovieItem::class.java)
            binding.movie = movieItem
        }


        binding.viewPager.adapter =
            movieItem.id?.let { MovieViewPagerAdapter(getBaseActivity(),titles.size, it) }
        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }
}