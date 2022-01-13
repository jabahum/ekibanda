package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class CastItem {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null
}