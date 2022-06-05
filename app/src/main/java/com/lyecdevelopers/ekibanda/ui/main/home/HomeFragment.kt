package com.lyecdevelopers.ekibanda.ui.main.home

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.Item
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVItem
import com.lyecdevelopers.ekibanda.databinding.HomeFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.adapters.MoviesAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TVsAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TheatersAdapter
import com.lyecdevelopers.ekibanda.ui.main.home.adapter.CustomAdapter
import com.lyecdevelopers.ekibanda.ui.main.interfaces.MovieItemListener
import com.lyecdevelopers.ekibanda.ui.main.interfaces.TheaterItemListener
import com.lyecdevelopers.ekibanda.ui.main.interfaces.TvsItemListener
import com.lyecdevelopers.ekibanda.utils.CommonUtils
import javax.inject.Inject

/**
 * created by jaba
 * */
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(), TheaterItemListener,
    TvsItemListener, MovieItemListener {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: HomeFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    private lateinit var handler: Handler

    lateinit var update: Runnable

    private var currentPage = 0

    private lateinit var _items: List<Item>
    private var _itemsMovies: List<MovieItem>? = null
    private var _itemsTVs: List<TVItem>? = null
    private var _itemsTheaters: List<TheaterItem>? = null

    override fun getViewModel(): HomeViewModel {
        homeViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.home_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {
        // auto scroll
        handler = Handler()
        update = Runnable {
            if (currentPage >= 8) {
                currentPage = 0
            } else {
                currentPage += 1
            }
            binding.vpImages.setCurrentItem(currentPage++, true)
            handler.postDelayed(update, 2000)
        }

        // fetch data
        // coming soon
        homeViewModel.comingResponse.observe(getBaseActivity()) {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        hideLoading()
                        binding.loading = false
                        _items = resource.data?.items!!
                        setComingSoon()
                    }
                    Resource.Status.ERROR -> {
                        hideLoading()
                        binding.loading = false
                    }
                    Resource.Status.LOADING -> {
                        showLoading("Fetching...")
                        binding.loading = true
                    }
                }
            }
        }

        // popular movies
        homeViewModel.popularMoviesResponse.observe(getBaseActivity()) {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.loading = false
                        _itemsMovies = resource.data?.items!!
                        binding.moviesList = _itemsMovies
                    }
                    Resource.Status.ERROR -> {
                        binding.loading = false
                    }
                    Resource.Status.LOADING -> {
                        binding.loading = true
                    }
                }
            }
        }
        // popular tvs
        homeViewModel.popularTVsResponse.observe(getBaseActivity()) {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.loading = false
                        _itemsTVs = resource.data?.items!!
                        binding.tvsList = _itemsTVs
                    }
                    Resource.Status.ERROR -> {
                        binding.loading = false
                    }
                    Resource.Status.LOADING -> {
                        binding.loading = true
                    }
                }
            }
        }
        // in theaters
        homeViewModel.inTheatersResponse.observe(getBaseActivity()) {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.loading = false
                        _itemsTheaters = resource.data?.items!!
                        binding.theatersList = _itemsTheaters
                    }
                    Resource.Status.ERROR -> {
                        binding.loading = false
                    }
                    Resource.Status.LOADING -> {
                        binding.loading = true

                    }
                }
            }
        }

        // populate the views
        // recyclerview
        //Movies
        binding.rvMovies.setHasFixedSize(true)
        val moviesAdapter = MoviesAdapter(this)
        val moviesLinearLayoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovies.layoutManager = moviesLinearLayoutManager
        binding.rvMovies.adapter = moviesAdapter

        // tvs
        binding.rvTvs.setHasFixedSize(true)
        val tVsAdapter = TVsAdapter(this)
        val tVsLinearLayoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTvs.layoutManager = tVsLinearLayoutManager
        binding.rvTvs.adapter = tVsAdapter

        // theaters
        binding.rvInTheaters.setHasFixedSize(true)
        val theatersAdapter = TheatersAdapter(this)
        val theatersLinearLayoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvInTheaters.layoutManager = theatersLinearLayoutManager
        binding.rvInTheaters.adapter = theatersAdapter


    }

    private fun setComingSoon() {
        // set the adapter
        val adapter = CustomAdapter(getBaseActivity(), _items)
        binding.vpImages.adapter = adapter

        binding.vpImages.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {}
            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(update, 2000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(update)
    }

    override fun onClick(view: View, theater: TheaterItem) {
        val selectedTheater: String = CommonUtils.gsonParser?.toJson(theater) ?: ""
        val bundle = Bundle()
        bundle.putString("theater", selectedTheater)
//        Navigation.findNavController(view).navigate(R.id.movieDetailFragment,bundle)
    }

    override fun onClick(view: View, tv: TVItem) {
        val selectedTV: String = CommonUtils.gsonParser?.toJson(tv) ?: ""
        val bundle = Bundle()
        bundle.putString("movie", selectedTV)
        Navigation.findNavController(view).navigate(R.id.movieDetailFragment,bundle)
    }

    override fun onClick(view: View, movie: MovieItem) {
        val selectedMovie: String = CommonUtils.gsonParser?.toJson(movie) ?: ""
        val bundle = Bundle()
        bundle.putString("movie", selectedMovie)
        Navigation.findNavController(view).navigate(R.id.movieDetailFragment,bundle)

    }

}