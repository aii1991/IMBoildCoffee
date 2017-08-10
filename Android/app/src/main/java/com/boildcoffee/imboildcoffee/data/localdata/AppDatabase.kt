package com.boildcoffee.imboildcoffee.data.localdata

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.boildcoffee.imboildcoffee.data.persistence.dao.UserDao
import com.boildcoffee.imboildcoffee.data.persistence.entity.User

/**
 * @author zjh
 * 2017/8/9
 */
@Database(
        entities = arrayOf(User::class),
        version = 1,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        private const val DB_NAME = "bc_im.appDatabase"

        fun createInMemoryDatabase(context: Context): AppDatabase
                = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java).build()

        fun createPersistentDatabase(context: Context): AppDatabase
                = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
    }
}