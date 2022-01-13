package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Directors
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Writers

class FullCast {
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

    @SerializedName("directors")
    @Expose
    var directors: Directors? = null

    @SerializedName("writers")
    @Expose
    var writers: Writers? = null

    @SerializedName("actors")
    @Expose
    var actors: List<Actor>? = null

    @SerializedName("others")
    @Expose
    var others: List<Other>? = null

    @SerializedName("errorMessage")
    @Expose
    var errorMessage: String? = null
}