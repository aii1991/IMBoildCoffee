package com.boildcoffee.imboildcoffee.ui

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.boildcoffee.imboildcoffee.R
import com.boildcoffee.imboildcoffee.data.persistence.entity.User
import com.boildcoffee.imboildcoffee.databinding.ActivityMainBinding
import com.boildcoffee.imboildcoffee.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {
    val TAG:String = MainActivity::class.java.simpleName


    private lateinit var userViewModel: UserViewModel
    private var userData:MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.mUsers.value = userData
        userViewModel.mUsers.observe(this, Observer {
            userData.addAll(it as List<User>)
            recyclerView.adapter.notifyDataSetChanged()
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerView.adapter = UserAdapter(userData)
        btInsert.setOnClickListener({
            userViewModel.insertUsers(User(name = etUserName.text.toString(),age = etAge.text.toString().toInt()))
        })

        userViewModel.loadAllUser()
    }
}
