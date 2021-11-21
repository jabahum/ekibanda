package com.lyecdevelopers.ekibanda

import com.lyecdevelopers.ekibanda.utils.AppLogger
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


open class Ekibanda : DaggerApplication(){

    override fun onCreate() {
        super.onCreate()
        AppLogger.init()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}
