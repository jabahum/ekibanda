package com.lyecdevelopers.ekibanda.di.modules.account

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.ekibanda.di.Key.ViewModelKey
import com.lyecdevelopers.ekibanda.ui.account.login.LoginViewModel
import com.lyecdevelopers.ekibanda.ui.account.register.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class AccountViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel?): ViewModel?
}