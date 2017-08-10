package com.boildcoffee.imboildcoffee

import android.app.Application

/**
 * @author zjh
 * 2017/8/9
 */
class BCApplication : Application(){
    val appComponent: AppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    override fun onCreate() {
        super.onCreate()
    }
}