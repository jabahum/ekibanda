package com.lyecdevelopers.ekibanda.data.local.pref

/**
 * shared preference interface class
 * created by jaba
 */
interface AppPreferenceManagerHelper {
    // selected
    var selectedCountry: String?

    //save api keys
    fun storeApiKey(key: String?)

    val apiKey: String?

    var accessToken: String?

    // user email
    var currentUserEmail: String?

    // user id
    var currentUserId: String?

    // user loggedIn
    val currentUserLoggedInMode: Int

    // user name
    var currentUserName: String?

    // user profile pic
    var currentUserProfilePicUrl: String?

    // user signedIn
    var signedIn: Boolean

    // user firebase token
    var userFirebaseToken: String?

    // user address
    var userAddress: String?

    // user phone/contact
    var userContact: String?

    // user Notification subscription
    var notificationOn: Boolean

    // user role
    var isAdmin: Boolean

    // clear
    fun clear()

    // country code
    var countryCode: String?
}