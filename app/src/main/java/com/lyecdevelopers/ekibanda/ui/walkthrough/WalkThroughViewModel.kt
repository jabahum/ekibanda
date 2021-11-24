package com.lyecdevelopers.ekibanda.ui.walkthrough

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject

class WalkThroughViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider
) :
    BaseViewModel()