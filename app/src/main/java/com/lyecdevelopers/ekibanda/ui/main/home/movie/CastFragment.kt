package com.lyecdevelopers.ekibanda.ui.main.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.CastFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.CastAdapter
import javax.inject.Inject

class CastFragment : BaseFragment<CastFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: CastFragmentBinding

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
        return R.layout.cast_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }


    private fun init() {
        // populate the views
        binding.rvCast.apply {
            setHasFixedSize(true)
            val castAdapter = CastAdapter()
            val moviesLinearLayoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            layoutManager = moviesLinearLayoutManager
            adapter = castAdapter

        }

    }
}