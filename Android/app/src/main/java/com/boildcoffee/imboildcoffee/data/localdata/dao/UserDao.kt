package com.boildcoffee.imboildcoffee.data.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.boildcoffee.imboildcoffee.data.persistence.entity.User
import io.reactivex.Flowable

/**
 * @author zjh
 * 2017/8/9
 */
@Dao
interface UserDao{
    @Query("SELECT * FROM t_user")
    fun getAllUsers():Flowable<List<User>>
    @Query("SELECT * FROM t_user WHERE id = :id")
    fun getUserById(id:Long):Flowable<User>
    @Insert
    fun insertUsers(vararg user: User)
    @Delete
    fun deleteUser(user:User)
}