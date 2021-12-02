package com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("fullTitle")
    @Expose
    var fullTitle: String? = null

    @SerializedName("year")
    @Expose
    var year: String? = null

    @SerializedName("releaseState")
    @Expose
    var releaseState: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("runtimeMins")
    @Expose
    var runtimeMins: String? = null

    @SerializedName("runtimeStr")
    @Expose
    var runtimeStr: String? = null

    @SerializedName("plot")
    @Expose
    var plot: String? = null

    @SerializedName("contentRating")
    @Expose
    var contentRating: String? = null

    @SerializedName("imDbRating")
    @Expose
    var imDbRating: String? = null

    @SerializedName("imDbRatingCount")
    @Expose
    var imDbRatingCount: String? = null

    @SerializedName("metacriticRating")
    @Expose
    var metacriticRating: String? = null

    @SerializedName("genres")
    @Expose
    var genres: String? = null

    @SerializedName("genreList")
    @Expose
    var genreList: List<Genre>? = null

    @SerializedName("directors")
    @Expose
    var directors: String? = null

    @SerializedName("directorList")
    @Expose
    var directorList: List<Director>? = null

    @SerializedName("stars")
    @Expose
    var stars: String? = null

    @SerializedName("starList")
    @Expose
    var starList: List<Star>? = null
}