package com.lyecdevelopers.ekibanda.ui.main.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Actor
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos.PhotoItem
import com.lyecdevelopers.ekibanda.databinding.PhotosFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.PhotosAdapter
import javax.inject.Inject

class PhotosFragment(private val movieId:String) : BaseFragment<PhotosFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: PhotosFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    private var _itemsPhotos: List<PhotoItem>? = null

    override fun getViewModel(): HomeViewModel {
        homeViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[HomeViewModel::class.java]
        return homeViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.photos_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }


    private fun init() {

        homeViewModel.loadPhotosFromServer(movieId)


        // photos
        homeViewModel.photosResponse.observe(getBaseActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.loading = false
                        _itemsPhotos = resource.data?.images?.items
                        binding.photosList = _itemsPhotos
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
        binding.rvPhotos.apply {
            setHasFixedSize(true)
            val photosAdapter = PhotosAdapter()
            val photosGridLayoutManager = GridLayoutManager(getBaseActivity(), 3)
            layoutManager = photosGridLayoutManager
            adapter = photosAdapter
        }


    }

}