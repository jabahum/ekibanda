package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class PhotoItem {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null
}