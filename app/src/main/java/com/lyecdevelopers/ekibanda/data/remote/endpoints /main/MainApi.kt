package com.lyecdevelopers.ekibanda.data.remote.endpoints.main

import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.ComingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {
    @GET("ComingSoon/{apiKey}")
    suspend fun getComingSoon(@Path("apiKey") apiKey: String): Response<ComingResponse>

}