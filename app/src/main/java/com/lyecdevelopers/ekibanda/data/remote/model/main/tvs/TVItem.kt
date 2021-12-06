package com.lyecdevelopers.ekibanda.data.remote.model.main.tvs

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TVItem {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("rank")
    @Expose
    var rank: String? = null

    @SerializedName("rankUpDown")
    @Expose
    var rankUpDown: String? = null

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

    @SerializedName("crew")
    @Expose
    var crew: String? = null

    @SerializedName("imDbRating")
    @Expose
    var imDbRating: String? = null

    @SerializedName("imDbRatingCount")
    @Expose
    var imDbRatingCount: String? = null
}