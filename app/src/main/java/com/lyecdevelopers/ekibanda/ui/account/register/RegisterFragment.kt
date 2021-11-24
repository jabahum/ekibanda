package com.lyecdevelopers.ekibanda.ui.account.register

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.RegisterFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject

class RegisterFragment : BaseFragment<RegisterFragmentBinding, RegisterViewModel>() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: RegisterFragmentBinding

    lateinit var registerViewModel: RegisterViewModel

    override fun getViewModel(): RegisterViewModel {
        registerViewModel =
            ViewModelProvider(
                getBaseActivity(),
                providerFactory
            )[RegisterViewModel::class.java]
        return registerViewModel
    }

    override fun getLayoutId(): Int {

        return R.layout.register_fragment
    }
}