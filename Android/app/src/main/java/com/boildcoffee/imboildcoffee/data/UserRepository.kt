package com.boildcoffee.imboildcoffee.data;

import com.boildcoffee.imboildcoffee.data.localdata.AppDatabase
import com.boildcoffee.imboildcoffee.data.persistence.entity.User
import io.reactivex.Flowable

/**
 * @author zjh
 *         2017/8/10
 */

class UserRepository(val appDatabase: AppDatabase) : IRepository<User>{


    override fun getData(dataId: Long): Flowable<User> {
        return appDatabase.userDao().getUserById(dataId)
    }

    override fun getDatas(): Flowable<List<User>> {
        return appDatabase.userDao().getAllUsers()
    }

    override fun insertData(vararg datas: User): List<User>{
        appDatabase.userDao().insertUsers(*datas)
        return datas.toList()
    }

    override fun deleteData(data: User) {
        appDatabase.userDao().deleteUser(data)
    }

    override fun deleteDatas() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
