package com.lyecdevelopers.ekibanda.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.BuildConfig
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.SplashFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import com.lyecdevelopers.ekibanda.ui.main.MainActivity
import javax.inject.Inject

/**
 * created by jaba
 * */
class SplashFragment : BaseFragment<SplashFragmentBinding, SplashViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: SplashFragmentBinding

    lateinit var splashViewModel: SplashViewModel

    private var handler: Handler = Handler()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = getViewDataBinding()
        init()
    }

    private fun init() {

        // set version name
        binding.versionName = "v" + BuildConfig.VERSION_NAME

        // handle loading
        handler.postDelayed({ newActivity(MainActivity::class.java) }, 2000)
    }
}