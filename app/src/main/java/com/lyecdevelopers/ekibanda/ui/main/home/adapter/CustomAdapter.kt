package com.lyecdevelopers.ekibanda.ui.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.lyecdevelopers.ekibanda.R
import com.lyecdevelopers.ekibanda.data.remote.model.main.comingsoon.Item
import com.squareup.picasso.Picasso

class CustomAdapter(mContext: Context, private val bannersDataList: List<Item>) : PagerAdapter() {
    private val mInflater: LayoutInflater = LayoutInflater.from(mContext)
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val pageView = mInflater.inflate(
            R.layout.vp_image_items,
            container, false
        ) as ViewGroup
        val imageView = pageView.findViewById<ImageView>(R.id.iv_item)
        Picasso.get()
            .load(bannersDataList[position].image)
            .into(imageView)
        container.addView(pageView)
        getItemPosition(pageView)
        return pageView
    }

    override fun getCount(): Int {
        return bannersDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}