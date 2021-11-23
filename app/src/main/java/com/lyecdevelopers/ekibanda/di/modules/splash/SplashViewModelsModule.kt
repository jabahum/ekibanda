package com.lyecdevelopers.ekibanda.di.modules.splash

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.ekibanda.di.Key.ViewModelKey
import com.lyecdevelopers.ekibanda.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class SplashViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel?): ViewModel?
}