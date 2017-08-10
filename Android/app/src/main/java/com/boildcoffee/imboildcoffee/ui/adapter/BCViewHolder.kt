package com.boildcoffee.imboildcoffee.ui.adapter

import android.databinding.ViewDataBinding
import android.view.View
import com.boildcoffee.imboildcoffee.R
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author zjh
 * 2017/8/10
 */
class BCViewHolder(view: View) : BaseViewHolder(view) {
    fun getBinding() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
}