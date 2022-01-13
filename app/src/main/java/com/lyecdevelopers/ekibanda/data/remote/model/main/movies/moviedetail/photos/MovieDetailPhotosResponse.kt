package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class MovieDetailPhotosResponse {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("originalTitle")
    @Expose
    var originalTitle: String? = null

    @SerializedName("fullTitle")
    @Expose
    var fullTitle: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("year")
    @Expose
    var year: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("releaseDate")
    @Expose
    var releaseDate: String? = null

    @SerializedName("runtimeMins")
    @Expose
    var runtimeMins: String? = null

    @SerializedName("runtimeStr")
    @Expose
    var runtimeStr: String? = null

    @SerializedName("plot")
    @Expose
    var plot: String? = null

    @SerializedName("plotLocal")
    @Expose
    var plotLocal: String? = null

    @SerializedName("plotLocalIsRtl")
    @Expose
    var plotLocalIsRtl: Boolean? = null

    @SerializedName("awards")
    @Expose
    var awards: String? = null

    @SerializedName("directors")
    @Expose
    var directors: String? = null

    @SerializedName("directorList")
    @Expose
    var directorList: List<Director>? = null

    @SerializedName("writers")
    @Expose
    var writers: String? = null

    @SerializedName("writerList")
    @Expose
    var writerList: List<Writer>? = null

    @SerializedName("stars")
    @Expose
    var stars: String? = null

    @SerializedName("starList")
    @Expose
    var starList: List<Star>? = null

    @SerializedName("actorList")
    @Expose
    var actorList: List<Actor>? = null

    @SerializedName("fullCast")
    @Expose
    var fullCast: Any? = null

    @SerializedName("genres")
    @Expose
    var genres: String? = null

    @SerializedName("genreList")
    @Expose
    var genreList: List<Genre>? = null

    @SerializedName("companies")
    @Expose
    var companies: String? = null

    @SerializedName("companyList")
    @Expose
    var companyList: List<Company>? = null

    @SerializedName("countries")
    @Expose
    var countries: String? = null

    @SerializedName("countryList")
    @Expose
    var countryList: List<Country>? = null

    @SerializedName("languages")
    @Expose
    var languages: String? = null

    @SerializedName("languageList")
    @Expose
    var languageList: List<Language>? = null

    @SerializedName("contentRating")
    @Expose
    var contentRating: String? = null

    @SerializedName("imDbRating")
    @Expose
    var imDbRating: String? = null

    @SerializedName("imDbRatingVotes")
    @Expose
    var imDbRatingVotes: String? = null

    @SerializedName("metacriticRating")
    @Expose
    var metacriticRating: String? = null

    @SerializedName("ratings")
    @Expose
    var ratings: Any? = null

    @SerializedName("wikipedia")
    @Expose
    var wikipedia: Any? = null

    @SerializedName("posters")
    @Expose
    var posters: Any? = null

    @SerializedName("images")
    @Expose
    var images: Images? = null

    @SerializedName("trailer")
    @Expose
    var trailer: Any? = null

    @SerializedName("boxOffice")
    @Expose
    var boxOffice: BoxOffice? = null

    @SerializedName("tagline")
    @Expose
    var tagline: String? = null

    @SerializedName("keywords")
    @Expose
    var keywords: String? = null

    @SerializedName("keywordList")
    @Expose
    var keywordList: List<String>? = null

    @SerializedName("similars")
    @Expose
    var similars: List<Similar>? = null

    @SerializedName("tvSeriesInfo")
    @Expose
    var tvSeriesInfo: Any? = null

    @SerializedName("tvEpisodeInfo")
    @Expose
    var tvEpisodeInfo: Any? = null

    @SerializedName("errorMessage")
    @Expose
    var errorMessage: Any? = null
}