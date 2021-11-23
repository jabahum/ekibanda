package com.lyecdevelopers.ekibanda.di.modules.walkthrough

import com.lyecdevelopers.ekibanda.ui.walkthrough.WalkThroughFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * created by jaba
 */
@Module
abstract class WalkThroughBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWalkThroughFragment(): WalkThroughFragment?
}