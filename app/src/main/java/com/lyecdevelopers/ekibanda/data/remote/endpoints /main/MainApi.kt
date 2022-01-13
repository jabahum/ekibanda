package com.lyecdevelopers.ekibanda.data.remote.endpoints.main

import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.ComingResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheatersResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MoviesResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.MovieDetailResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.MovieDetailCastResponse
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos.MovieDetailPhotosResponse
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

    @GET("Title/{apiKey}/{movieId}")
    suspend fun getMovieDetail(@Path("apiKey") apiKey: String, @Path("movieId") movieId: String) : Response<MovieDetailResponse>

    @GET("Title/{apiKey}/{movieId}/FullCast")
    suspend fun getMovieDetailCast(@Path("apiKey") apiKey: String, @Path("movieId") movieId: String) : Response<MovieDetailCastResponse>

    @GET("Title/{apiKey}/{movieId}/Images")
    suspend fun getMovieDetailPhotos(@Path("apiKey") apiKey: String, @Path("movieId") movieId: String) : Response<MovieDetailPhotosResponse>
}