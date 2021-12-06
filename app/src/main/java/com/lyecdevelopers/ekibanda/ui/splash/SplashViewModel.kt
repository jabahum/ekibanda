package com.lyecdevelopers.ekibanda.ui.splash

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject
/**
 * created by jaba
 * */
class SplashViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()