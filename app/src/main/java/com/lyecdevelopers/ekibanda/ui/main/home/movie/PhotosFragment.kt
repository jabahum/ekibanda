package com.lyecdevelopers.ekibanda.ui.main.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.PhotosFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.PhotosAdapter
import javax.inject.Inject

class PhotosFragment : BaseFragment<PhotosFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: PhotosFragmentBinding

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
        return R.layout.photos_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }


    private fun init() {
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