package com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Actor {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("asCharacter")
    @Expose
    var asCharacter: String? = null
}