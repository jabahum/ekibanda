package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Language {
    @SerializedName("key")
    @Expose
    var key: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null
}