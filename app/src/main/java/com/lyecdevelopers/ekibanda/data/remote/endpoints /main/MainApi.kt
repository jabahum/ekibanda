package com.lyecdevelopers.ekibanda.data.remote.endpoints.main

import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.ComingResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheatersResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MoviesResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {
    @GET("ComingSoon/{apiKey}")
    suspend fun getComingSoon(@Path("apiKey") apiKey: String): Response<ComingResponse>

    @GET("MostPopularMovies/{apiKey}")
    suspend fun getPopularMovies(@Path("apiKey") apiKey: String): Response<MoviesResponse>

    @GET("MostPopularTVs/{apiKey}")
    suspend fun getPopularTVs(@Path("apiKey") apiKey: String): Response<TVsResponse>

    @GET("InTheaters/{apiKey}")
    suspend fun getInTheaters(@Path("apiKey") apiKey: String): Response<TheatersResponse>
}