package com.lyecdevelopers.ekibanda.ui.account.login

import com.lyecdevelopers.ekibanda.data.local.rx.AppSchedulerProvider
import com.lyecdevelopers.ekibanda.data.remote.endpoints.login.LoginApi
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginApi: LoginApi,
    private val schedulers: AppSchedulerProvider
) : BaseViewModel()