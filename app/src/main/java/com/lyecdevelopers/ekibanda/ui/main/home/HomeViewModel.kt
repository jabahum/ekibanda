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
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.MovieDetailCastResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos.MovieDetailPhotosResponse
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

    // cast
    private val _castResponse = MediatorLiveData<Resource<MovieDetailCastResponse?>>()

    val castResponse: LiveData<Resource<MovieDetailCastResponse?>> get() = _castResponse

    // photos
    private val _photosResponse = MediatorLiveData<Resource<MovieDetailPhotosResponse?>>()

    val photosResponse: LiveData<Resource<MovieDetailPhotosResponse?>> get() = _photosResponse

    init {
        loadComingSoonFromServer()
        loadPopularMoviesFromServer()
        loadPopularTVsFromServer()
        loadIntheatersFromServer()
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
    private fun loadIntheatersFromServer(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _inTheatersResponse.postValue(Resource.loading(null))
                mainApi.getInTheaters(BuildConfig.API_KEY).let {
                    if (it.isSuccessful){
                        _inTheatersResponse.postValue(Resource.success(it.body()))
                    }else{
                        _inTheatersResponse.postValue(Resource.error(it.errorBody().toString(),null))
                    }
                }
            }
        }
    }

    //  photos
    fun loadPhotosFromServer(movieId:String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _photosResponse.postValue(Resource.loading(null))
                mainApi.getMovieDetailPhotos(BuildConfig.API_KEY,movieId).let {
                    if (it.isSuccessful) {
                        _photosResponse.postValue(Resource.success(it.body()))
                    } else
                        _photosResponse.postValue(Resource.error(it.errorBody().toString(),
                            null))
                }
            }

        }
    }

    //  cast
    fun loadCastFromServer(movieId: String) {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                _castResponse.postValue(Resource.loading(null))
                mainApi.getMovieDetailCast(BuildConfig.API_KEY,movieId).let {
                    if (it.isSuccessful) {
                        _castResponse.postValue(Resource.success(it.body()))
                    } else
                        _castResponse.postValue(Resource.error(it.errorBody().toString(),
                            null))
                }
            }

        }
    }

}