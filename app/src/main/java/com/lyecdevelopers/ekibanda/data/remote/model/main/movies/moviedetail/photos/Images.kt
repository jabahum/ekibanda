package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Images {
    @SerializedName("imDbId")
    @Expose
    var imDbId: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("fullTitle")
    @Expose
    var fullTitle: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("year")
    @Expose
    var year: String? = null

    @SerializedName("items")
    @Expose
    var items: List<PhotoItem>? = null

    @SerializedName("errorMessage")
    @Expose
    var errorMessage: String? = null
}