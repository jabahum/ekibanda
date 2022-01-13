package com.lyecdevelopers.ekibanda.ui.main.home.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.local.enums.VIEW_TYPE
import com.lyecdevelopers.ekibanda.data.remote.model.main.movies.moviedetail.photos.PhotoItem
import com.lyecdevelopers.ekibanda.databinding.EmptyViewBinding
import com.lyecdevelopers.ekibanda.databinding.PhotoItemBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseViewHolder

class PhotosAdapter  :
    RecyclerView.Adapter<BaseViewHolder>() {
    private var dataList: List<PhotoItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val rowItemBinding: PhotoItemBinding =
                    PhotoItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                PhotoViewHolder(
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

    fun addPhoto(datasets: List<PhotoItem>?) {
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
            mBinding.message = "No Photos Found"
        }
    }

    // Main ViewHolder
    inner class PhotoViewHolder constructor(binding: PhotoItemBinding?) :
        BaseViewHolder(binding?.root) {
        private val mBinding: PhotoItemBinding? = binding
        override fun onBind(position: Int) {
            val movieItem: PhotoItem = dataList[position]
            mBinding?.apply {
                photo = movieItem
            }
        }
    }
}