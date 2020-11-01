package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.view.vieholders.RestaurantViewHolder
import com.padc.fooddeliveryapp.view.vieholders.RestaurantViewTwoViewHolder
import com.padc.shared.adapters.BaseAdapter
import com.padc.shared.viewholders.BaseViewHolder

class VerticalAdapter(private val mDelegate: RestaurantItemDelegate) : BaseAdapter<BaseViewHolder<RestaurantVO>,RestaurantVO>() {
    private var mViewType = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<RestaurantVO> {
        return when(mViewType){
            0 -> {val v = LayoutInflater.from(parent.context).inflate(R.layout.vertical_item_view,parent,false)
                 RestaurantViewHolder(mDelegate,v)}

            1 -> {val v = LayoutInflater.from(parent.context).inflate(R.layout.vetical_two_item_view,parent,false)
                RestaurantViewHolder(mDelegate,v)}

            else ->{
                val v = LayoutInflater.from(parent.context).inflate(R.layout.vertical_item_view,parent,false)
                RestaurantViewHolder(mDelegate,v)
            }
        }



    }

    fun setViewType(viewType: Int){
        mViewType = viewType
    }
}