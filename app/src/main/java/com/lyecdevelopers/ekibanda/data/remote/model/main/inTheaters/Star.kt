package com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Star {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}