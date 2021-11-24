package com.lyecdevelopers.ekibanda.di.modules.account

import android.app.Application
import com.lyecdevelopers.ekibanda.data.local.pref.PreferenceManager
import com.lyecdevelopers.ekibanda.data.remote.endpoints.login.LoginApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * created by jaba
 */
@Module
class AccountModule {
    @AccountScope
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @AccountScope
    @Provides
    fun providerPreferenceManger(application: Application?): PreferenceManager? {
        return application?.let { PreferenceManager(it) }
    }
}