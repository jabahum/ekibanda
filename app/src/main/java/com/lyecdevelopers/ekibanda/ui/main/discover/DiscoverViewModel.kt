package com.lyecdevelopers.ekibanda.ui.main.discover

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.data.remote.endpoints.main.MainApi
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(
    private val mainApi: MainApi,
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()