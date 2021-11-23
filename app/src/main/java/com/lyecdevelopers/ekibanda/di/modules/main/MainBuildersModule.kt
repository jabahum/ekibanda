package com.lyecdevelopers.ekibanda.di.modules.main

import com.lyecdevelopers.ekibanda.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class MainBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment?
}