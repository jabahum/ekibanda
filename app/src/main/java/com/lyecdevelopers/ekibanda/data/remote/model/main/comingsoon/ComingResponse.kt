package com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ComingResponse {
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    @SerializedName("errorMessage")
    @Expose
    var errorMessage: String? = null
}