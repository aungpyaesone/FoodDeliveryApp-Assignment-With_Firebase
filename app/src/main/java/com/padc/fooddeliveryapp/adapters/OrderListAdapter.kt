package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.delegates.OrderItemDelegate
import com.padc.fooddeliveryapp.view.vieholders.OrderItemViewHolder
import com.padc.shared.adapters.BaseAdapter
import com.padc.shared.viewholders.BaseViewHolder

class OrderListAdapter(private val mDelegate: OrderItemDelegate) : BaseAdapter<BaseViewHolder<BurgerVO>,BurgerVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BurgerVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.order_item_view,parent,false)
        return OrderItemViewHolder(mDelegate,v)
    }
}