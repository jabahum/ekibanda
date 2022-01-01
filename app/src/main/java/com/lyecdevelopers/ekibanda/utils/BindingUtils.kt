package com.lyecdevelopers.ekibanda.utils

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import timber.log.Timber
import java.util.*

object BindingUtils {

    @BindingAdapter("image")
    @JvmStatic
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.get().load(imageUrl).fit().into(view)
    }


    @JvmStatic
    @BindingAdapter("drawableImage")
    fun drawableImage(imageView: ImageView, id: Number?) {
        if (id != null) {
            try {
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, id.toInt()))
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["date"], requireAll = false)
    fun setDateTime(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTime(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["day"], requireAll = false)
    fun setDateTimeDay(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTimeDay(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["month"], requireAll = false)
    fun setDateTimeMonth(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTimeMonth(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("ugxText")
    fun showUGX(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "UGX 0"
            return
        }
        tv.text = String.format("UGX %s", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("extra")
    fun setExtra(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Add Extra "
            return
        }
        tv.text = String.format("Add Extra (%s)", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("cartItems")
    fun showCartItems(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 items"
            return
        }
        tv.text = String.format("%s items", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("qty")
    fun showQty(tv: TextView, value: Number) {
        tv.text = String.format("%s", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("grandTotal")
    fun showTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Grand Total : UGX 0 "
            return
        }
        tv.text = String.format("Grand Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("deliveryTotal")
    fun showDeliveryTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Delivery Charge : UGX 0 "
            return
        }
        tv.text = String.format("Delivery Charge : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("serviceTax")
    fun showServiceTax(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Total : UGX 0 "
            return
        }
        tv.text = String.format("Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["total", "delivery"])
    fun showGrandTotal(tv: TextView, total: Number?, deliveryTotal: Number?) {
        if (total == null || deliveryTotal == null) {
            tv.text = "Total Charge : UGX 0 "
            return
        }
        val grandTotal = total.toInt() + deliveryTotal.toInt()
        tv.text = String.format("Total Charge : UGX %s ", CommonUtils.commas(grandTotal))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("itemsTotal")
    fun showItemTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Items Total : UGX 0 "
            return
        }
        tv.text = String.format("Items Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("percent")
    fun showPercent(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 %"
            return
        }
        tv.text = String.format("-%s %%", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["price", "discount"])
    fun showDiscount(tv: TextView, price: Double, discount: Double) {
        tv.text = String.format(
            "UGX %s",
            CommonUtils.commas(CommonUtils.calculateDiscount(price, discount))
        )
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["price", "totalQty"])
    fun showAmount(tv: TextView, price: Number?, totalQty: Number?) {
        tv.text = String.format(
            "UGX %s", CommonUtils.commas(
                CommonUtils.calculateAmount(
                    price!!, totalQty!!
                )
            )
        )
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("kgText")
    fun showKgs(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 kg"
            return
        }
        tv.text = String.format("%.1f kg", value.toDouble())
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("userName")
    fun showKgs(tv: TextView, value: String?) {
        if (value == null) {
            tv.text = "Hey User"
            return
        }
        tv.text = String.format("Hey %s", value)
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter("acreText")
    fun showAcres(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 Acres"
            return
        }
        tv.text = String.format("%.2f Acres", value.toDouble())
    }

    @SuppressLint("DefaultLocale", "ResourceAsColor")
    @JvmStatic
    @BindingAdapter("status")
    fun showStatus(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Pending"
            return
        }
        when (value.toInt()) {
            1 -> tv.text = "Pending"
            2 -> tv.text = "Scheduled for Delivery"
            3 -> tv.text = "Delivered"
            4 -> tv.text = "Canceled"
        }
    }

    @SuppressLint("DefaultLocale")
    @JvmStatic
    @BindingAdapter(value = ["doubleText", "placeHolder"], requireAll = false)
    fun showDouble(tv: TextView, value: Number?, placeHolder: String?) {
        if (value == null || value.toDouble() == 0.0) {
            tv.text = placeHolder ?: "0"
            return
        }
        tv.text = String.format("%d", value.toInt())
    }

    @JvmStatic
    @BindingAdapter(value = ["commas", "placeHolder"], requireAll = false)
    fun showCommas(tv: TextView, value: Number?, placeHolder: String?) {
        if (value == null || value.toInt() == 0) {
            tv.text = placeHolder ?: "0"
            return
        }
        tv.text = String.format(Locale.US, "%s", CommonUtils.commas(value.toInt()))
    }

}