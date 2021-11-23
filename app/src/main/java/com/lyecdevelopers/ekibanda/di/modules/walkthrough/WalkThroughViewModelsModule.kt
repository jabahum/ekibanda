package com.lyecdevelopers.ekibanda.di.modules.walkthrough

import androidx.lifecycle.ViewModel
import com.lyecdevelopers.ekibanda.di.Key.ViewModelKey
import com.lyecdevelopers.ekibanda.ui.walkthrough.WalkThroughViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * created by jaba
 */
@Module
abstract class WalkThroughViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(WalkThroughViewModel::class)
    abstract fun bindWalkThroughViewModel(viewModel: WalkThroughViewModel?): ViewModel?
}