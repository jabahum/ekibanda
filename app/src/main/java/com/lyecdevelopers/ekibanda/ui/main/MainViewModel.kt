package com.lyecdevelopers.ekibanda.ui.main

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.data.remote.endpoints.main.MainApi
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject
/**
 * created by jaba
 * */
class MainViewModel @Inject constructor(
    private val mainApi: MainApi,
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()