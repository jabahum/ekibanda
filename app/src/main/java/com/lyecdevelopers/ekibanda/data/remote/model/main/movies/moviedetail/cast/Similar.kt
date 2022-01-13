package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Similar {
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

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("plot")
    @Expose
    var plot: String? = null

    @SerializedName("directors")
    @Expose
    var directors: String? = null

    @SerializedName("stars")
    @Expose
    var stars: String? = null

    @SerializedName("genres")
    @Expose
    var genres: String? = null

    @SerializedName("imDbRating")
    @Expose
    var imDbRating: String? = null
}