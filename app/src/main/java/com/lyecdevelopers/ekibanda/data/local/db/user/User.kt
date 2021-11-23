package com.lyecdevelopers.ekibanda.data.local.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * created by jaba
 */
@Entity
class User {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String

    @ColumnInfo(name = "fullName")
    var fullName: String

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String

    @ColumnInfo(name = "email")
    var email: String

    @ColumnInfo(name = "password")
    var password: String

    constructor() {
        id = null.toString()
        fullName = null.toString()
        phoneNumber = null.toString()
        email = null.toString()
        password = null.toString()
    }

    @Ignore
    constructor(
        id: String,
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String
    ) {
        this.id = id
        this.fullName = fullName
        this.phoneNumber = phoneNumber
        this.email = email
        this.password = password
    }
}