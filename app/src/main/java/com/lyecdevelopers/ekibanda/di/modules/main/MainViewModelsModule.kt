package com.lyecdevelopers.ekibanda.di.modules.main

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.ekibanda.di.Key.ViewModelKey
import com.lyecdevelopers.ekibanda.ui.main.MainViewModel
import com.lyecdevelopers.ekibanda.ui.main.discover.DiscoverViewModel
import com.lyecdevelopers.ekibanda.ui.main.home.HomeViewModel
import com.lyecdevelopers.ekibanda.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel?): ViewModel?


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(DiscoverViewModel::class)
    abstract fun bindDiscoverViewModel(viewModel: DiscoverViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel?): ViewModel?

}