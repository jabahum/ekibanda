package com.lyecdevelopers.ekibanda.ui.main.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Actor
import com.lyecdevelopers.ekibanda.databinding.CastFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.CastAdapter
import javax.inject.Inject

class CastFragment(private val movieId:String) : BaseFragment<CastFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: CastFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    private var _itemsCast: List<Actor>? = null


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


        homeViewModel.loadCastFromServer(movieId)

        // cast
        homeViewModel.castResponse.observe(getBaseActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.loading = false
                        _itemsCast = resource.data?.actorList
                        binding.castList = _itemsCast
                    }
                    Resource.Status.ERROR -> {
                        binding.loading = false
                    }
                    Resource.Status.LOADING -> {
                        binding.loading = true

                    }
                }
            }
        })


        // populate the views
        binding.rvCast.apply {
            setHasFixedSize(true)
            val castAdapter = CastAdapter()
            val moviesLinearLayoutManager = GridLayoutManager(getBaseActivity(), 3)
            layoutManager = moviesLinearLayoutManager
            adapter = castAdapter

        }

    }
}