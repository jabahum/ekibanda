package com.lyecdevelopers.ekibanda.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.local.enums.VIEW_TYPE
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem
import com.lyecdevelopers.ekibanda.databinding.EmptyViewBinding
import com.lyecdevelopers.ekibanda.databinding.TheaterItemBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseViewHolder
import com.lyecdevelopers.ekibanda.ui.main.interfaces.TheaterItemListener

class TheatersAdapter(private val listener: TheaterItemListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var dataList: List<TheaterItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val rowItemBinding: TheaterItemBinding =
                    TheaterItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                TheaterViewHolder(
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

    fun addTheater(datasets: List<TheaterItem>?) {
        if (datasets != null) {
            dataList = datasets
        }
        notifyDataSetChanged()
    }

    fun clearItems() {
//        dataList
    }

    // NoItem ViewHolder
    class EmptyViewHolder constructor(binding: EmptyViewBinding) :
        BaseViewHolder(binding.root) {
        private val mBinding: EmptyViewBinding = binding
        override fun onBind(position: Int) {
            mBinding.message = "No Theater Movies Found"
        }

    }

    // Main ViewHolder
    inner class TheaterViewHolder constructor(binding: TheaterItemBinding?) :
        BaseViewHolder(binding?.root) {
        private val mBinding: TheaterItemBinding? = binding
        override fun onBind(position: Int) {
            val theaterItem: TheaterItem = dataList[position]
            if (mBinding != null) {
                mBinding.theater = theaterItem
            }
        }
    }
}