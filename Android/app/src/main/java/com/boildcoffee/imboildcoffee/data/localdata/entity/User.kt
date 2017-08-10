package com.boildcoffee.imboildcoffee.data.persistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author zjh
 * 2017/8/8
 */
@Entity(tableName = "t_user")
data class User(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var uid:Long = 0,
                @ColumnInfo(name = "name") var name:String,
                @ColumnInfo(name = "age") var age:Int)
