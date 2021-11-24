package com.lyecdevelopers.ekibanda.ui.account.login

import androidx.lifecycle.ViewModelProvider
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.ViewModelProviderFactory
import com.lyecdevelopers.ekibanda.databinding.LoginFragmentBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseFragment
import javax.inject.Inject

class LoginFragment : BaseFragment<LoginFragmentBinding, LoginViewModel>() {


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var binding: LoginFragmentBinding

    lateinit var loginViewModel: LoginViewModel

    override fun getViewModel(): LoginViewModel {
        loginViewModel =
            ViewModelProvider(getBaseActivity()!!, providerFactory).get(LoginViewModel::class.java)
        return loginViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.login_fragment
    }
}