package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Other {
    @SerializedName("job")
    @Expose
    var job: String? = null

    @SerializedName("items")
    @Expose
    var items: List<CastItem>? = null
}