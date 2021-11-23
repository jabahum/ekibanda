package com.lyecdevelopers.ekibanda.di.ViewModelModule;

import androidx.lifecycle.ViewModelProvider;


import com.lyecdevelopers.ekibanda.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/**
 * created by jaba
 */
@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
