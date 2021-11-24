package com.lyecdevelopers.ekibanda.utils

import android.R
import android.annotation.SuppressLint
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import java.util.*

object BindingUtils {
    /* @JvmStatic
     @BindingAdapter("imageDrawable")
     fun setImage(imageView: ImageView, id: Number?) {
         if (id != null) {
             try {
                 imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, id.toInt()))
             } catch (e: Exception) {
                 Timber.e(e)
             }
         }
     }
 */
    /*   @SuppressLint("DefaultLocale")
    @BindingAdapter(value = {"zonedDate", "format"}, requireAll = false)
    public static void setZonedDateTime(TextView tv, ZonedDateTime dateTime, String format) {
        if (dateTime == null) {
            tv.setText("");
        } else {
            if (format == null) {
                format = "dd MM yyyy";
            }
            tv.setText(DateTimeFormatter.ofPattern(format).format(dateTime));
        }
    }*/
    @SuppressLint("DefaultLocale")
    @BindingAdapter(value = ["date"], requireAll = false)
    fun setDateTime(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTime(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter(value = ["day"], requireAll = false)
    fun setDateTimeDay(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTimeDay(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter(value = ["month"], requireAll = false)
    fun setDateTimeMonth(tv: TextView, dateTime: String?) {
        if (dateTime == null) {
            tv.text = "No Date"
            return
        }
        tv.text = String.format("%s", CommonUtils.dateToTimeMonth(dateTime))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("ugxText")
    fun showUGX(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "UGX 0"
            return
        }
        tv.text = String.format("UGX %s", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("extra")
    fun setExtra(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Add Extra "
            return
        }
        tv.text = String.format("Add Extra (%s)", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("cartItems")
    fun showCartItems(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 items"
            return
        }
        tv.text = String.format("%s items", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("qty")
    fun showQty(tv: TextView, value: Number) {
        tv.text = String.format("%s", value.toInt())
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("grandTotal")
    fun showTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Grand Total : UGX 0 "
            return
        }
        tv.text = String.format("Grand Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("deliveryTotal")
    fun showDeliveryTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Delivery Charge : UGX 0 "
            return
        }
        tv.text = String.format("Delivery Charge : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("serviceTax")
    fun showServiceTax(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Total : UGX 0 "
            return
        }
        tv.text = String.format("Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
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
    @BindingAdapter("itemsTotal")
    fun showItemTotal(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "Items Total : UGX 0 "
            return
        }
        tv.text = String.format("Items Total : UGX %s ", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("percent")
    fun showPercent(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 %"
            return
        }
        tv.text = String.format("-%s %%", CommonUtils.commas(value.toDouble()))
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("bind:price", "bind:discount")
    fun showDiscount(tv: TextView, price: Double, discount: Double) {
        tv.text = String.format(
            "UGX %s",
            CommonUtils.commas(CommonUtils.calculateDiscount(price, discount))
        )
    }

    @SuppressLint("DefaultLocale")
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
    @BindingAdapter("kgText")
    fun showKgs(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 kg"
            return
        }
        tv.text = String.format("%.1f kg", value.toDouble())
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("userName")
    fun showKgs(tv: TextView, value: String?) {
        if (value == null) {
            tv.text = "Hey User"
            return
        }
        tv.text = String.format("Hey %s", value)
    }

    @SuppressLint("DefaultLocale")
    @BindingAdapter("acreText")
    fun showAcres(tv: TextView, value: Number?) {
        if (value == null) {
            tv.text = "0 Acres"
            return
        }
        tv.text = String.format("%.2f Acres", value.toDouble())
    }

    @SuppressLint("DefaultLocale", "ResourceAsColor")
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
    @BindingAdapter(value = ["doubleText", "placeHolder"], requireAll = false)
    fun showDouble(tv: TextView, value: Number?, placeHolder: String?) {
        if (value == null || value.toDouble() == 0.0) {
            tv.text = placeHolder ?: "0"
            return
        }
        tv.text = String.format("%d", value.toInt())
    }

    @BindingAdapter(value = ["commas", "placeHolder"], requireAll = false)
    fun showCommas(tv: TextView, value: Number?, placeHolder: String?) {
        if (value == null || value.toInt() == 0) {
            tv.text = placeHolder ?: "0"
            return
        }
        tv.text = String.format(Locale.US, "%s", CommonUtils.commas(value.toInt()))
    }

    /*@BindingAdapter("capitalize")
    fun capitalizeText(tv: TextView, text: String?) {
        tv.setText(StringUtils.capitalize(text))
    }*/

    /*@BindingAdapter({"crops"})
    public static void setCrops(AppCompatSpinner spinner, List<Crop> crops) {
        if (crops != null) {
            List<String> parsedCrops = CommonUtils.cropsToString(crops);
            parsedCrops.add(0, "Select Crop");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(),
                    android.R.layout.simple_spinner_item, parsedCrops);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }*/
   /* @BindingAdapter("districts")
    fun setDistricts(spinner: AppCompatSpinner, districts: List<String?>?) {
        if (districts != null) {
            districts.add(0, "Select District")
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                spinner.getContext(),
                R.layout.simple_spinner_item, districts
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
            adapter.notifyDataSetChanged()
        }
    }*/

    @BindingAdapter("options")
    fun setOptions(spinner: AppCompatSpinner, options: List<String?>?) {
        if (options != null) {
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                spinner.context,
                R.layout.simple_spinner_item, options
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    /*@BindingAdapter({"districts"})
    public static void setDistrictsAutoComplete(AutoCompleteTextView autoCompleteTextView, List<String> districts) {
        if (districts != null) {
            CustomSpinnerItemAdapter adapter = new CustomSpinnerItemAdapter(autoCompleteTextView.getContext(), R.layout.custom_spinner_item_row, districts);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }*/
    @BindingAdapter(value = ["values", "current"], requireAll = false)
    fun setSpinnerData(spinner: AppCompatSpinner, data: List<String?>?, current: String?) {
        if (data != null) {
            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                spinner.context,
                R.layout.simple_spinner_item, data
            )
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            adapter.notifyDataSetChanged()
            if (current != null && data.contains(current)) {
                spinner.setSelection(adapter.getPosition(current))
            }
        }
    }

    /*    @BindingAdapter(value = {"data", "current"}, requireAll = false)
    public static void setCustomSpinnerData(AppCompatSpinner spinner, List<String> data, String current) {
        if (data != null) {
            SpinnerItemAdapter adapter = new SpinnerItemAdapter(spinner.getContext(), R.layout.spinner_item_row, data);

            spinner.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            if (current != null && data.contains(current)) {
                spinner.setSelection(adapter.getPosition(current));
            }
        }
    }*/
    // Disabled
    /*@BindingAdapter({"enabled"})
    public static void setSpinnerEnabled(AppCompatSpinner spinner, @Nullable Boolean enabled) {
        if (enabled == null || enabled) {
            spinner.setBackground(spinner.getContext().getResources().getDrawable(R.drawable.textview_demand_dropdown_selector));
            spinner.setEnabled(true);
            // Set Text Color
            if (spinner.getChildAt(spinner.getSelectedItemPosition()) != null) {
                ((TextView) spinner.getChildAt(spinner.getSelectedItemPosition())).setTextColor(spinner.getContext().getResources().getColor(R.color.colorPrimary));
            }
        } else {
            spinner.setBackground(spinner.getContext().getResources().getDrawable(R.drawable.border_grey));
            spinner.setEnabled(false);

            if (spinner.getChildAt(spinner.getSelectedItemPosition()) != null) {
                ((TextView) spinner.getChildAt(spinner.getSelectedItemPosition())).setTextColor(spinner.getContext().getResources().getColor(R.color.grey_500));
            }
        }
    }*/
    /*    @BindingAdapter({"spinnerEnabled"})
    public static void setSpinnerImageEnabled(ImageView imageView, @Nullable Boolean enabled) {
        if (enabled == null || enabled) {
            imageView.setEnabled(true);
            imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.textview_demand_dropdown_selector));
        } else {
            imageView.setImageDrawable(AppCompatResources.getDrawable(imageView.getContext(), R.drawable.border_grey));
            imageView.setEnabled(false);
        }
    }*/
    /* @BindingAdapter({"enabled"})
    public static void setTextViewEnabled(TextView textView, @Nullable Boolean enabled) {
        if (enabled == null || enabled) {
            textView.setEnabled(true);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.grey_500));
            textView.setEnabled(false);
        }
    }*/
    @BindingAdapter("layout_weight")
    fun setLayoutWeight(view: View, weight: Float) {
        val layoutParams: LinearLayout.LayoutParams = view.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = weight
        view.layoutParams = layoutParams
    }
}