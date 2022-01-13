package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class BoxOffice {
    @SerializedName("budget")
    @Expose
    var budget: String? = null

    @SerializedName("openingWeekendUSA")
    @Expose
    var openingWeekendUSA: String? = null

    @SerializedName("grossUSA")
    @Expose
    var grossUSA: String? = null

    @SerializedName("cumulativeWorldwideGross")
    @Expose
    var cumulativeWorldwideGross: String? = null
}