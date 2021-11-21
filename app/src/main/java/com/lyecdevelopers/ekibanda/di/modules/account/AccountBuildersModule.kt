package com.lyecdevelopers.ekibanda.di.modules.account

import com.lyecdevelopers.ekibanda.ui.account.login.LoginFragment
import com.lyecdevelopers.ekibanda.ui.account.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class AccountBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment?

    @ContributesAndroidInjector
    abstract fun contributeRegisterFragment(): RegisterFragment?
}