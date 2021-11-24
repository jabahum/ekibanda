package com.lyecdevelopers.ekibanda.ui.main

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.MainFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: MainFragmentBinding

    lateinit var mainViewModel: MainViewModel

    override fun getViewModel(): MainViewModel {
        mainViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[MainViewModel::class.java]
        return mainViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.main_fragment
    }
}