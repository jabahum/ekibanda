package com.lyecdevelopers.ekibanda.ui.account.register

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.data.remote.endpoints.login.LoginApi
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val schedulers: AppSchedulerProvider,
    private val loginApi: LoginApi
) : BaseViewModel()