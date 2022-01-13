package com.lyecdevelopers.ekibanda.ui.main.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Actor
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos.PhotoItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVItem
import com.lyecdevelopers.ekibanda.ui.main.adapters.MoviesAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TVsAdapter
import com.lyecdevelopers.ekibanda.ui.main.adapters.TheatersAdapter
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.CastAdapter
import com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter.PhotosAdapter

object BindingUtils {
    @BindingAdapter("movies")
    @JvmStatic
    fun setMovies(recyclerView: RecyclerView, movieList: List<MovieItem>?) {
        val adapter: MoviesAdapter? = recyclerView.adapter as MoviesAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addMovie(movieList)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("tvs")
    @JvmStatic
    fun setTVs(recyclerView: RecyclerView, TVsList: List<TVItem>?) {
        val adapter: TVsAdapter? = recyclerView.adapter as TVsAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addTVs(TVsList)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("theaters")
    @JvmStatic
    fun setTheaters(recyclerView: RecyclerView, theaterList: List<TheaterItem>?) {
        val adapter: TheatersAdapter? = recyclerView.adapter as TheatersAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addTheater(theaterList)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("castItems")
    @JvmStatic
    fun setActors(recyclerView: RecyclerView, castItems: List<Actor>?) {
        val adapter: CastAdapter? = recyclerView.adapter as CastAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addActor(castItems)
            adapter.notifyDataSetChanged()
        }
    }
    @BindingAdapter("photoItems")
    @JvmStatic
    fun setPhotos(recyclerView: RecyclerView, photoItems: List<PhotoItem>?) {
        val adapter: PhotosAdapter? = recyclerView.adapter as PhotosAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addPhoto(photoItems)
            adapter.notifyDataSetChanged()
        }
    }

}