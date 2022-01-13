package com.lyecdevelopers.ekibanda.ui.main.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.ReviewsFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.ReviewsAdapter
import javax.inject.Inject

class ReviewsFragment(private val movieId:String) : BaseFragment<ReviewsFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: ReviewsFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    override fun getViewModel(): HomeViewModel {
        homeViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.reviews_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {
        // populate the views
        binding.rvReviews.apply {
            setHasFixedSize(true)
            val reviewsAdapter = ReviewsAdapter()
            val reviewsLinearLayoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            layoutManager = reviewsLinearLayoutManager
            adapter = reviewsAdapter
        }
    }

}