package com.lyecdevelopers.ekibanda.di.modules.main

import android.app.Application
import com.lyecdevelopers.ekibanda.data.local.pref.PreferenceManager
import com.lyecdevelopers.ekibanda.data.remote.endpoints.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * created by jaba
 */

@Module
class MainModule {
    @MainScope
    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

    @MainScope
    @Provides
    fun providerPreferenceManger(application: Application?): PreferenceManager? {
        return application?.let { PreferenceManager(it) }
    }

}