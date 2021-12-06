package com.lyecdevelopers.ekibanda.ui.main.interfaces

import android.view.View
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem

interface MovieItemListener {
    fun onClick(view: View, movie: MovieItem)
}