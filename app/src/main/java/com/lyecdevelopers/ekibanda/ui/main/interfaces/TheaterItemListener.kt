package com.lyecdevelopers.ekibanda.ui.main.interfaces

import android.view.View
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem

interface TheaterItemListener {
    fun onClick(view: View, theater: TheaterItem)

}