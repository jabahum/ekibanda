package com.lyecdevelopers.ekibanda.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.lyecdevelopers.ekibanda.BuildConfig
import com.lyecdevelopers.ekibanda.data.remote.endpoints.main.MainApi
import com.lyecdevelopers.ekibanda.data.remote.model.common.Resource
import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.ComingResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheatersResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MoviesResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVsResponse
import com.lyecdevelopers.ekibanda.ui._base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val mainApi: MainApi,
) : BaseViewModel() {

    // coming soon
    private val _comingSoonResponse = MediatorLiveData<Resource<ComingResponse?>>()

    val comingResponse: LiveData<Resource<ComingResponse?>> get() = _comingSoonResponse

    // popular movies
    private val _popularMoviesResponse = MediatorLiveData<Resource<MoviesResponse?>>()

    val popularMoviesResponse: LiveData<Resource<MoviesResponse?>> get() = _popularMoviesResponse

    // popular tvs
    private val _popularTVsResponse = MediatorLiveData<Resource<TVsResponse?>>()

    val popularTVsResponse: LiveData<Resource<TVsResponse?>> get() = _popularTVsResponse

    // in theaters
    private val _inTheatersResponse = MediatorLiveData<Resource<TheatersResponse?>>()

    val inTheatersResponse: LiveData<Resource<TheatersResponse?>> get() = _inTheatersResponse

    init {
        loadComingSoonFromServer()
        loadPopularMoviesFromServer()
        loadPopularTVsFromServer()
        loadInTheatersFromServer()
    }

    // coming soon
    private fun loadComingSoonFromServer() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _comingSoonResponse.postValue(Resource.loading(null))
                mainApi.getComingSoon(BuildConfig.API_KEY).let {
                    if (it.isSuccessful) {
                        _comingSoonResponse.postValue(Resource.success(it.body()))
                    } else
                        _comingSoonResponse.postValue(Resource.error(it.errorBody().toString(),
                            null))
                }
            }

        }
    }

    // popular movies
    private fun loadPopularMoviesFromServer() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _popularMoviesResponse.postValue(Resource.loading(null))
                mainApi.getPopularMovies(BuildConfig.API_KEY).let {
                    if (it.isSuccessful) {
                        _popularMoviesResponse.postValue(Resource.success(it.body()))
                    } else
                        _popularMoviesResponse.postValue(
                            Resource.error(
                                it.errorBody().toString(),
                                null
                            )
                        )
                }
            }

        }
    }

    // popular tvs
    private fun loadPopularTVsFromServer() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _popularTVsResponse.postValue(Resource.loading(null))
                mainApi.getPopularTVs(BuildConfig.API_KEY).let {
                    if (it.isSuccessful) {
                        _popularTVsResponse.postValue(Resource.success(it.body()))
                    } else
                        _popularTVsResponse.postValue(Resource.error(it.errorBody().toString(),
                            null))
                }
            }

        }
    }

    // in theaters
    private fun loadInTheatersFromServer() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                _inTheatersResponse.postValue(Resource.loading(null))
                mainApi.getInTheaters(BuildConfig.API_KEY).let {
                    if (it.isSuccessful) {
                        _inTheatersResponse.postValue(Resource.success(it.body()))
                    } else
                        _inTheatersResponse.postValue(Resource.error(it.errorBody().toString(),
                            null))
                }
            }

        }
    }

}