package com.lyecdevelopers.ekibanda.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lyecdevelopers.ekibanda.data.local.db.user.User
import com.lyecdevelopers.ekibanda.data.local.db.user.UserDao

/**
 * created by jaba
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class EkibandaDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {
        fun getInstance(context: Context): EkibandaDatabase {
            return Room.databaseBuilder<EkibandaDatabase>(
                context.applicationContext,
                EkibandaDatabase::class.java, "EkibandaDatabase.db"
            )
                .build()
        }
    }
}