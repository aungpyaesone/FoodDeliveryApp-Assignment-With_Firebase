package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.view.vieholders.CategoryViewHolder
import com.padc.shared.adapters.BaseAdapter
import com.padc.shared.viewholders.BaseViewHolder

class HorizontalAdapter() : BaseAdapter<BaseViewHolder<CategoryVO>,CategoryVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CategoryVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.horizontial_item_view,parent,false)
        return CategoryViewHolder(v)
    }

}