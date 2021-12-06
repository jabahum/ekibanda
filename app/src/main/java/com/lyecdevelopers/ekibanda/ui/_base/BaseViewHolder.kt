package com.lyecdevelopers.ekibanda.ui._base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lyecdevelopers.ekibanda.data.remote.model.main.inTheaters.TheaterItem
import java.util.*

/**
 * created by jaba
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(position: Int)
}