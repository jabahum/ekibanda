package com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.local.enums.VIEW_TYPE
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.MovieItem
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.cast.Actor
import com.lyecdevelopers.ekibanda.databinding.ActorItemBinding
import com.lyecdevelopers.ekibanda.databinding.EmptyViewBinding
import com.lyecdevelopers.ekibanda.databinding.MovieItemBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseViewHolder
import com.lyecdevelopers.ekibanda.ui.main.adapters.MoviesAdapter

class CastAdapter  :
    RecyclerView.Adapter<BaseViewHolder>() {


        private var dataList: List<Actor> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val rowItemBinding: ActorItemBinding =
                    ActorItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                ActorViewHolder(
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
        }    }

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

    fun addActor(datasets: List<Actor>?) {
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
            mBinding.message = "No Cast Found"
        }
    }

    // Main ViewHolder
    inner class ActorViewHolder constructor(binding: ActorItemBinding?) :
        BaseViewHolder(binding?.root) {
        private val mBinding: ActorItemBinding? = binding
        override fun onBind(position: Int) {
            val movieItem: Actor = dataList[position]
            mBinding?.apply {
                actor = movieItem
            }
        }
    }
}