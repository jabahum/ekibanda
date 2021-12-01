package com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Director {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}