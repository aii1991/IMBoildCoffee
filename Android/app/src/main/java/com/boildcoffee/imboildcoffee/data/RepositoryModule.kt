package com.boildcoffee.imboildcoffee.data

import com.boildcoffee.imboildcoffee.data.localdata.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author zjh
 * 2017/8/10
 */
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(appDatabase: AppDatabase) = UserRepository(appDatabase)
}