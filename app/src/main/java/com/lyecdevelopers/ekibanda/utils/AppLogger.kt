
package com.lyecdevelopers.ekibanda.utils

import com.lyecdevelopers.ekibanda.BuildConfig
import timber.log.Timber

/**
 * created by jaba
 */
object AppLogger {
    fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun d(s: String?, vararg objects: Any?) {
        Timber.d(s, objects)
    }

    fun d(throwable: Throwable?, s: String?, vararg objects: Any?) {
        Timber.d(throwable, s, objects)
    }

    fun i(s: String?, vararg objects: Any?) {
        Timber.i(s, objects)
    }

    fun i(throwable: Throwable?, s: String?, vararg objects: Any?) {
        Timber.i(throwable, s, objects)
    }

    fun w(s: String?, vararg objects: Any?) {
        Timber.w(s, objects)
    }

    fun w(throwable: Throwable?, s: String?, vararg objects: Any?) {
        Timber.w(throwable, s, objects)
    }

    fun e(s: String?, vararg objects: Any?) {
        Timber.e(s, objects)
    }

    fun e(throwable: Throwable?, s: String?, vararg objects: Any?) {
        Timber.e(throwable, s, objects)
    }
}