package com.lyecdevelopers.ekibanda.ui.main.home

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.Item
import com.lyecdevelopers.ekibanda.databinding.HomeFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.home.adapter.CustomAdapter
import javax.inject.Inject


class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: HomeFragmentBinding

    lateinit var homeViewModel: HomeViewModel

    private lateinit var handler: Handler

    lateinit var update: Runnable

    private var currentPage = 0

    private lateinit var _items : List<Item>

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
        homeViewModel.comingResponse.observe(getBaseActivity(), {
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
        })

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

}