package com.boildcoffee.imboildcoffee

import com.boildcoffee.imboildcoffee.data.RepositoryModule
import com.boildcoffee.imboildcoffee.data.localdata.DataModule
import com.boildcoffee.imboildcoffee.ui.UserViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * @author zjh
 * 2017/8/9
 */
@Component(modules = arrayOf(AppModule::class, DataModule::class, RepositoryModule::class))
@Singleton
interface AppComponent{
    fun inject(userViewModel: UserViewModel)
}