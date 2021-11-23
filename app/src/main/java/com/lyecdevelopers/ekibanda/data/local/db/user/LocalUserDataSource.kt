package com.lyecdevelopers.ekibanda.data.local.db.user

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * created by jaba
 */
class LocalUserDataSource(private val mUserDao: UserDao) : UserDataSource {
    override val users: Flowable<User?>?
        get() = TODO("Not yet implemented")

    override fun insertUser(user: User?): Single<Long?>? {
        TODO("Not yet implemented")
    }

    override fun deleteAllUsers() {
        TODO("Not yet implemented")
    }

    override fun insertAll(users: Array<User?>?): Single<List<Long?>?>? {
        TODO("Not yet implemented")
    }

    override fun update(id: String?, text: String?): Completable? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String?): Completable? {
        TODO("Not yet implemented")
    }

}