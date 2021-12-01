package com.lyecdevelopers.ekibanda.data.local.db.user

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * created by jaba
 */
class LocalUserDataSource(private val mUserDao: UserDao) : UserDataSource {
    override val users: Flowable<List<User?>>?
        get() = mUserDao.all

    override fun insertUser(user: User?): Single<Long?>? {
        return mUserDao.insertUser(user)
    }

    override fun deleteAllUsers() {
        mUserDao.deleteAllUser()
    }

    override fun insertAll(users: Array<User?>?): Single<List<Long?>?>? {
        return mUserDao.insertAll(users)
    }

    override fun update(id: String?, text: String?): Completable? {
        return mUserDao.update(id, text)
    }

    override fun delete(id: String?): Completable? {
        return mUserDao.delete(id)
    }

}