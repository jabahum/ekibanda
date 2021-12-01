package com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Genre {
    @SerializedName("key")
    @Expose
    var key: String? = null

    @SerializedName("value")
    @Expose
    var value: String? = null
}