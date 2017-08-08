package com.boildcoffee.imboildcoffee.ui

import android.arch.lifecycle.LifecycleActivity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.boildcoffee.imboildcoffee.BR
import com.boildcoffee.imboildcoffee.R
import com.boildcoffee.imboildcoffee.databinding.ActivityMainBinding
import com.boildcoffee.imboildcoffee.persistence.User

class MainActivity : LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val user = User("jason",21)
        binding.setVariable(BR.user,user)
        binding.executePendingBindings()
    }
}
