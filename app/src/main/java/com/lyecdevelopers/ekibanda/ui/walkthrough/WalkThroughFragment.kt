package com.lyecdevelopers.ekibanda.ui.walkthrough

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.WalkthroughFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject
/***
 * created by jaba
 * */
class WalkThroughFragment : BaseFragment<WalkthroughFragmentBinding, WalkThroughViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: WalkthroughFragmentBinding

    lateinit var walkThroughViewModel: WalkThroughViewModel

    override fun getViewModel(): WalkThroughViewModel {
        walkThroughViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[WalkThroughViewModel::class.java]
        return walkThroughViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.walkthrough_fragment
    }
}