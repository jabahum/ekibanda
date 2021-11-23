package com.lyecdevelopers.ekibanda.data.local.pref

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * created by jaba
 */
class PreferenceManager @SuppressLint("CommitPrefEdits") constructor(context: Context) :
    AppPreferenceManagerHelper {
    // share pref variable
    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = mPrefs.edit()
    override var selectedCountry: String?
        get() = null
        set(selectedCountry) {}

    override fun storeApiKey(key: String?) {}
    override val apiKey: String?
        get() = null
    override var accessToken: String?
        get() = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)
        set(accessToken) {
            mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
        }
    override var currentUserEmail: String?
        get() = null
        set(email) {}
    override var currentUserId: String?
        get() = mPrefs.getString(SIGNEDINUSERID, null)
        set(userId) {
            mPrefs.edit().putString(SIGNEDINUSERID, userId).apply()
        }
    override val currentUserLoggedInMode: Int
        get() = 0
    override var currentUserName: String?
        get() = mPrefs.getString(SIGNEDINUSERNAME, "[]")
        set(userName) {
            mPrefs.edit().putString(SIGNEDINUSERNAME, userName).apply()
        }
    override var currentUserProfilePicUrl: String?
        get() = null
        set(profilePicUrl) {}
    override var signedIn: Boolean
        get() = mPrefs.getBoolean(SIGNEDINEMAIL, false)
        set(signedIn) {
            mPrefs.edit().putBoolean(SIGNEDINEMAIL, signedIn).apply()
        }
    override var userFirebaseToken: String?
        get() = null
        set(firebaseToken) {}
    override var userAddress: String?
        get() = mPrefs.getString(SIGNEDINUSERADDRESS, "[]")
        set(address) {
            mPrefs.edit().putString(SIGNEDINUSERADDRESS, address).apply()
        }
    override var userContact: String?
        get() = mPrefs.getString(SIGNEDINUSERNUMBER, "[]")
        set(contact) {
            mPrefs.edit().putString(SIGNEDINUSERNUMBER, contact).apply()
        }
    override var notificationOn: Boolean
        get() = false
        set(turnedOn) {}

    override fun clear() {
        editor.clear()
        editor.apply()
    }

    override var countryCode: String?
        get() = mPrefs.getString(SIGNEDINCOUNTRYCODE, "[]")
        set(contact) {
            mPrefs.edit().putString(SIGNEDINCOUNTRYCODE, contact).apply()
        }
    override var isAdmin: Boolean
        get() = false
        set(isAdmin) {}

    companion object {
        private const val PREF_NAME = "ekibanda"

        // user details
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val SIGNEDINEMAIL = "SIGNEDINEMAIL"
        private const val SIGNEDINUSERID = "SIGNEDINUSERID"
        private const val SIGNEDINUSERNAME = "SIGNEDINUSERNAME"
        private const val SIGNEDINUSERADDRESS = "SIGNEDINUSERADDRESS"
        private const val SIGNEDINUSERNUMBER = "SIGNEDINUSERNUMBER"
        private const val SIGNEDINCOUNTRYCODE = "SIGNEDINCOUNTRYCODE"
    }

}