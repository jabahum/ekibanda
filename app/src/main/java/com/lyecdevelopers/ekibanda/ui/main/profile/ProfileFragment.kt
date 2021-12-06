package com.lyecdevelopers.ekibanda.ui.main.profile

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.HomeFragmentBinding
import com.lyecdevelopers.ekibanda.databinding.ProfileFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject
/**
 * created by jaba
 * */
class ProfileFragment : BaseFragment<ProfileFragmentBinding, ProfileViewModel>() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: HomeFragmentBinding

    lateinit var profileViewModel: ProfileViewModel

    override fun getViewModel(): ProfileViewModel {

        profileViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[ProfileViewModel::class.java]
        return profileViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.profile_fragment
    }
}