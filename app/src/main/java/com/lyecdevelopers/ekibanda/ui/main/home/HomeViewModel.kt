package com.lyecdevelopers.ekibanda.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.lyecdevelopers.ekibanda.BuildConfig
import com.lyecdevelopers.ekibanda.data.remote.endpoints.main.MainApi
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.ComingResponse
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import com.lyecdevelopers.ekibanda.utils.CommonUtils.showError
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val mainApi: MainApi,
) : BaseViewModel() {

    private val _comingSoonResponse = MediatorLiveData<Resource<ComingResponse?>>()

    val comingResponse: LiveData<Resource<ComingResponse?>> get() = _comingSoonResponse

    init {
        loadComingSoonFromServer()
    }

    private fun loadComingSoonFromServer() {
        viewModelScope.launch {
            _comingSoonResponse.postValue(Resource.loading(null))
            mainApi.getComingSoon(BuildConfig.API_KEY).let {
                if (it.isSuccessful){
                    _comingSoonResponse.postValue(Resource.success(it.body()))
                }else
                    _comingSoonResponse.postValue(Resource.error(it.errorBody().toString(),null))
            }
        }
    }

}