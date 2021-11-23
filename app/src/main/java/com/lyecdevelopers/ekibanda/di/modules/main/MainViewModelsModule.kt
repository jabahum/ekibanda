package com.lyecdevelopers.ekibanda.di.modules.main

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.ekibanda.di.Key.ViewModelKey
import com.lyecdevelopers.ekibanda.ui.main.MainViewModel
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
}