package com.lyecdevelopers.ekibanda.ui.main.discover

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.DiscoverFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject

class DiscoverFragment : BaseFragment<DiscoverFragmentBinding, DiscoverViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: DiscoverFragmentBinding

    lateinit var discoverViewModel: DiscoverViewModel

    override fun getLayoutId(): Int {
        return R.layout.discover_fragment
    }

    override fun getViewModel(): DiscoverViewModel {
        discoverViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[DiscoverViewModel::class.java]
        return discoverViewModel
    }
}