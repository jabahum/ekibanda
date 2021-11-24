package com.lyecdevelopers.ekibanda.ui.splash

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.SplashFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject

class SplashFragment : BaseFragment<SplashFragmentBinding, SplashViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: SplashFragmentBinding

    lateinit var splashViewModel: SplashViewModel

    override fun getViewModel(): SplashViewModel {
        splashViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[SplashViewModel::class.java]
        return splashViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.splash_fragment
    }
}