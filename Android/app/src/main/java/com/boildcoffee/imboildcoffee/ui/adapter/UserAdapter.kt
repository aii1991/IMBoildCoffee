package com.boildcoffee.imboildcoffee.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.boildcoffee.imboildcoffee.R
import com.boildcoffee.imboildcoffee.data.persistence.entity.User
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * @author zjh
 * 2017/8/10
 */
class UserAdapter(data: MutableList<User>?) : BaseQuickAdapter<User, BCViewHolder>(R.layout.item_user,data) {

    override fun convert(helper: BCViewHolder?, item: User?) {
        val binding = helper?.getBinding()
        binding?.setVariable(BR.user,item)
        binding?.executePendingBindings()
    }

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutResId, parent, false) ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

}