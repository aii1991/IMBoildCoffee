package com.boildcoffee.imboildcoffee.data.localdata

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author zjh
 * 2017/8/9
 */
@Module
class DataModule{
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context) = AppDatabase.createPersistentDatabase(context)
}