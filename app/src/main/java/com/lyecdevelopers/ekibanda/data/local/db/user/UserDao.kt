package com.lyecdevelopers.ekibanda.data.local.db.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * created by jaba
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: Flowable<User?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?): Single<Long?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: Array<User?>?): Single<List<Long?>?>?

    @Query("DELETE FROM user WHERE id = :id")
    fun delete(id: String?): Completable?

    @Query("UPDATE user SET fullName = :text WHERE id = :id")
    fun update(id: String?, text: String?): Completable?

    @Query("DELETE FROM user")
    fun deleteAllUser()

    @get:Query("SELECT COUNT(*) FROM user")
    val rowCount: Flowable<Int?>?
}