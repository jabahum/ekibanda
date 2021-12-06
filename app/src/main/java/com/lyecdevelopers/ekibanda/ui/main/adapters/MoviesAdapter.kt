package com.lyecdevelopers.ekibanda.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.local.enums.VIEW_TYPE
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.databinding.EmptyViewBinding
import com.lyecdevelopers.ekibanda.databinding.MovieItemBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseViewHolder
import com.lyecdevelopers.ekibanda.ui.main.interfaces.MovieItemListener

class MoviesAdapter(private val listener: MovieItemListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var dataList: List<MovieItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val rowItemBinding: MovieItemBinding =
                    MovieItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                MovieViewHolder(
                    rowItemBinding
                )
            }
            1 -> {
                val emptyViewBinding = EmptyViewBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                EmptyViewHolder(emptyViewBinding)
            }
            else -> {
                val emptyViewBinding = EmptyViewBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                EmptyViewHolder(emptyViewBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return if (dataList.isEmpty()) {
            1
        } else {
            dataList.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList.isEmpty()) {
            VIEW_TYPE.EMPTY.ordinal
        } else {
            VIEW_TYPE.NORMAL.ordinal
        }
    }

    fun addMovie(datasets: List<MovieItem>?) {
        if (datasets != null) {
            dataList = datasets
        }
        notifyDataSetChanged()
    }

    fun clearItems() {
//        dataList.
    }

    // NoItem ViewHolder
    class EmptyViewHolder constructor(binding: EmptyViewBinding) :
        BaseViewHolder(binding.root) {
        private val mBinding: EmptyViewBinding = binding
        override fun onBind(position: Int) {
            mBinding.message = "No Movies Found"
        }


    }

    // Main ViewHolder
    inner class MovieViewHolder constructor(binding: MovieItemBinding?) :
        BaseViewHolder(binding?.root) {
        private val mBinding: MovieItemBinding? = binding
        override fun onBind(position: Int) {
            val movieItem: MovieItem = dataList[position]
            if (mBinding != null) {
                mBinding.movie = movieItem
            }
        }
    }
}