package com.lyecdevelopers.ekibanda.di.modules.walkthrough

import android.app.Application
import com.lyecdevelopers.ekibanda.data.local.pref.PreferenceManager
import dagger.Module
import dagger.Provides


/**
 * created by jaba
 */
@Module
class WalkThroughModule {
    @WalkThroughScope
    @Provides
    fun providerPreferenceManger(application: Application?): PreferenceManager? {
        return application?.let { PreferenceManager(it) }
    }
}