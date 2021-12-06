package com.lyecdevelopers.ekibanda.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.local.enums.VIEW_TYPE
import com.lyecdevelopers.ekibanda.data.remote.model.main.tvs.TVItem
import com.lyecdevelopers.ekibanda.databinding.EmptyViewBinding
import com.lyecdevelopers.ekibanda.databinding.TvItemBinding
import com.lyecdevelopers.ekibanda.ui._base.BaseViewHolder
import com.lyecdevelopers.ekibanda.ui.main.interfaces.TvsItemListener

class TVsAdapter(private val listener: TvsItemListener) : RecyclerView.Adapter<BaseViewHolder>() {

    private var dataList: List<TVItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> {
                val rowItemBinding: TvItemBinding =
                    TvItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                TVsViewHolder(
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

    fun addTVs(datasets: List<TVItem>?) {
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
            mBinding.message = "No TVs  Found"
        }


    }

    // Main ViewHolder
    inner class TVsViewHolder constructor(binding: TvItemBinding?) :
        BaseViewHolder(binding?.root) {
        private val mBinding: TvItemBinding? = binding
        override fun onBind(position: Int) {
            val tvItem: TVItem = dataList[position]
            if (mBinding != null) {
                mBinding.tv = tvItem
            }
        }
    }
}