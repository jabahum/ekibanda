package com.lyecdevelopers.ekibanda.data.local.rx

import io.reactivex.Scheduler

/**
 * created by jaba
 */
interface SchedulerProvider {
    fun computation(): Scheduler?
    fun io(): Scheduler?
    fun ui(): Scheduler?
}