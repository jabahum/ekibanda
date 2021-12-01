package com.lyecdevelopers.ekibanda.data.local.db.user

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * created by jaba
 */
interface UserDataSource {
    val users: Flowable<List<User?>>?
    fun insertUser(user: User?): Single<Long?>?
    fun deleteAllUsers()
    fun insertAll(users: Array<User?>?): Single<List<Long?>?>?
    fun update(id: String?, text: String?): Completable?
    fun delete(id: String?): Completable?
}