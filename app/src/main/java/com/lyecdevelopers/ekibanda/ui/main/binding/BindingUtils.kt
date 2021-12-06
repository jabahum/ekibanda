package com.lyecdevelopers.ekibanda.ui.main.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVItem
import com.lyecdevelopers.ekibanda.ui.main.adapters.MoviesAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TVsAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TheatersAdapter

class BindingUtils {
    @BindingAdapter("movies")
    fun setMovies(recyclerView: RecyclerView, movieList: List<MovieItem>) {
        val adapter: MoviesAdapter? = recyclerView.adapter as MoviesAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addMovie(movieList)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("tvs")
    fun setTVs(recyclerView: RecyclerView, TVsList: List<TVItem>) {
        val adapter: TVsAdapter? = recyclerView.adapter as TVsAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addTVs(TVsList)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("theaters")
    fun setTheaters(recyclerView: RecyclerView, theaterList: List<TheaterItem>) {
        val adapter: TheatersAdapter? = recyclerView.adapter as TheatersAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addTheater(theaterList)
            adapter.notifyDataSetChanged()
        }
    }
}