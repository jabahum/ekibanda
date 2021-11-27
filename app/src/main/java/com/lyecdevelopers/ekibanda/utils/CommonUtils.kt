package com.lyecdevelopers.ekibanda.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Base64
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject
import retrofit2.HttpException
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {
    var months =
        arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    var passwordVal = "^" +  //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +  //any letter
            "(?=.*[@#$%^&+=])" +  //at least 1 special character
            "(?=\\S+$)" +  //no white spaces
            ".{4,}" +  //at least 4 characters
            "$"
    private var gson: Gson? = null
    val gsonParser: Gson?
        get() {
            if (null == gson) {
                val builder = GsonBuilder()
                gson = builder.create()
            }
            return gson
        }

    @SuppressLint("all")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun zero(number: Int): String {
        return if (number < 10) {
            String.format(Locale.US, "0%d", number)
        } else {
            number.toString()
        }
    }

    fun numberSeparator(value: Int): String {
        return NumberFormat.getNumberInstance(Locale.US).format(value.toLong())
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isSimCardAvailable(context: Context): Boolean {
        val tm =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager //gets the current TelephonyManager
        return tm.simState != TelephonyManager.SIM_STATE_ABSENT
    }

    fun month(date: String?): Int {
        val dateString = toDate(date, "yyyy-MM-dd") //new Date(date);
        return dateString!!.month
    }

    fun toDate(date: String?, format: String?): Date? {
        return try {
            SimpleDateFormat(format, Locale.US).parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }

    fun getDate(year: Int, month: Int, day: Int): Date {
        val cal = Calendar.getInstance()
        cal[Calendar.YEAR] = year
        cal[Calendar.MONTH] = month
        cal[Calendar.DAY_OF_MONTH] = day
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0
        return cal.time
    }

    fun find(a: Array<String>, target: String): Int {
        for (i in a.indices) if (a[i] == target) return i
        return -1
    }

    fun bitMapToBase64(bmp: Bitmap?): String? {
        return if (bmp != null) {
            val bao = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, bao)
            bmp.recycle()
            val byteArray = bao.toByteArray()
            Base64.encodeToString(byteArray, Base64.DEFAULT)
        } else {
            null
        }
    }

    fun dateToString(date: Date?, format: String?): String? {
        return try {
            SimpleDateFormat(format, Locale.US).format(date)
        } catch (e: Exception) {
            null
        }
    }

    fun stringToImage(base64: String?): Bitmap? {
        return try {
            val decodedString = Base64.decode(base64, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        } catch (e: Exception) {
            null
        }
    }

    val currentDate: Date
        get() = GregorianCalendar.getInstance().time

    fun showKeyboard(context: Context) {
        val inputMethodManager =
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun closeKeyboard(context: Context) {
        val inputMethodManager =
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    fun commas(number: Double?): String {
        if (number == null) return "0"
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(number)
    }

    fun commas(number: Int?): String {
        if (number == null) return "0"
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(number)
    }

    fun convertPixelsToDp(px: Float, context: Context): Int {
        val resources = context.resources
        val metrics = resources.displayMetrics
        val dp = px / (metrics.densityDpi / 160f)
        return dp.toInt()
    }

    fun numberToNth(n: Int?): String {
        if (n == null || n <= 0) return ""
        return if (n in 11..13) {
            n.toString() + "ᵗʰ"
        } else when (n % 10) {
            1 -> n.toString() + "ˢᵗ"
            2 -> n.toString() + "ⁿᵈ"
            3 -> n.toString() + "ʳᵈ"
            else -> n.toString() + "ᵗʰ"
        }
    }

    fun getLastYears(number: Int): List<String> {
        val years: MutableList<String> = ArrayList()
        var prevYear: Calendar
        for (i in 0..number) {
            prevYear = Calendar.getInstance()
            prevYear.add(Calendar.YEAR, -1 * i)
            years.add(prevYear[Calendar.YEAR].toString() + "")
        }
        return years
    }

    val currentMonth: String
        get() {
            val cal = Calendar.getInstance()
            return SimpleDateFormat("MMMM", Locale.US).format(cal.time)
        }

    fun capitalize(text: String?): String {
        var text = text
        if (text != null && !text.isEmpty()) {
            text = text.toLowerCase()
            val sb = StringBuilder(text)
            sb.setCharAt(0, Character.toUpperCase(sb[0]))
            return sb.toString()
        }
        return ""
    }

    fun dateToTime(dateString: String?): String {

        // Get date from string
        val dateFormatter =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        var date: Date? = null
        try {
            date = dateFormatter.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        // Get time from date
        val timeFormatter = SimpleDateFormat("dd MMM yyyy", Locale.US)

        //Date dateString = toDate(date, "yyyy-MM-dd'T'HH:mm:ss"); //new Date(date);
        return timeFormatter.format(date)
    }

    fun dateToTimeMonth(dateString: String): String {

        // Get date from string
        val dateFormatter =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        var date: Date? = null
        try {
            date = dateFormatter.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        // Get time from date
        val timeFormatter = SimpleDateFormat("MMM",Locale.US)

        //Date dateString = toDate(date, "yyyy-MM-dd'T'HH:mm:ss"); //new Date(date);
        return timeFormatter.format(date)
    }

    fun dateToTimeDay(dateString: String): String {

        // Get date from string
        val dateFormatter =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        var date: Date? = null
        try {
            date = dateFormatter.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        // Get time from date
        val timeFormatter = SimpleDateFormat("dd", Locale.US)

        //Date dateString = toDate(date, "yyyy-MM-dd'T'HH:mm:ss"); //new Date(date);
        return timeFormatter.format(date)
    }

    fun splitText(text: String): String {
        val strings = text.split(" ").toTypedArray()
        return if (strings.size > 1) {
            val finalString = StringBuilder()
            for (i in strings.indices) {
                if (i != strings.size - 1) {
                    finalString.append(strings[i]).append("\n")
                } else {
                    finalString.append(strings[i])
                }
            }
            finalString.toString()
        } else {
            text
        }
    }


    val currentTime: String
        get() {
            val dateFormatter =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
            val calendar = GregorianCalendar.getInstance()
            return dateFormatter.format(calendar.time)
        }

    fun getConnectivityStatusString(context: Context): String? {
        var status: String? = null
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetwork: NetworkInfo? = null
        if (cm != null) {
            activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) {
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                    status = "Wifi enabled"
                    return status
                } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                    status = "Mobile data enabled"
                    return status
                }
            } else {
                status = "No internet is available"
                return status
            }
        }
        return status
    }

    /*private fun validatePhoneNumber(phoneNumber: String): Boolean {
        // validate phone numbers of format "1234567890"
        return if (phoneNumber.matches("\\d{10}")) true else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) true else if (phoneNumber.matches(
                "\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"
            )
        ) true else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) true else if (phoneNumber.matches(
                "\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"
            )
        ) true else  // return false if nothing matches the input
            if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}")) true else phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}")
    }*/

    fun showError(e: Throwable?): String? {
        var message = ""
        try {
            if (e is IOException) {
                message = "No internet connection!"
            } else if (e is HttpException) {
                val errorBody = e.response().errorBody()!!.string()
                val jObj = JSONObject(errorBody)
                message = jObj.getString("msg")
            }
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        if (TextUtils.isEmpty(message)) {
            message = "Unknown error occurred! Check LogCat."
        }
        return message
    }

    fun calculateDiscount(price: Double, discount: Double): Double {
        return price - discount / 100 * price
    }

    fun calculateAmount(price: Number, qty: Number): Double {
        return price.toDouble() * qty.toDouble()
    }
}