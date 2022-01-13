package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Genre {
    @SerializedName("key")
    @Expose
    var key: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null
}