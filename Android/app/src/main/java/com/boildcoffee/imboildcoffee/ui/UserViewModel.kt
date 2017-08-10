package com.boildcoffee.imboildcoffee.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.boildcoffee.imboildcoffee.BCApplication
import com.boildcoffee.imboildcoffee.data.UserRepository
import com.boildcoffee.imboildcoffee.data.persistence.entity.User
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author zjh
 * 2017/8/9
 */
class UserViewModel(application:Application) : AndroidViewModel(application){
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var userRepository:UserRepository

    val mUsers: MutableLiveData<MutableList<User>> = MutableLiveData()

    init {
        (application as BCApplication).appComponent.inject(this)
    }

    fun insertUsers(vararg users:User){
        compositeDisposable.add(
            Flowable.empty<List<User>>()
                    .doOnSubscribe({
                        userRepository.insertData(*users)
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        if (it.isNotEmpty()){
                            mUsers.value?.addAll(it)
                            mUsers.value = mUsers.value
                        }
                    })
        )
    }

    fun loadAllUser(){
        compositeDisposable.add(
                userRepository.getDatas()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (it.isNotEmpty()){
                                mUsers.value?.clear()
                                mUsers.value?.addAll(it)
                                mUsers.value = mUsers.value
                            }
                        })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}