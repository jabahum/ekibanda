package com.lyecdevelopers.ekibanda.ui.main.interfaces

import android.view.View
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVItem

interface TvsItemListener {
    fun onClick(view: View, tv: TVItem)

}