package com.padc.fooddeliveryapp.view.vieholders

import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.vertical_item_view.view.*

class RestaurantViewHolder(private val mDelegate: RestaurantItemDelegate,itemView: View) : BaseViewHolder<RestaurantVO>(itemView){
    override fun bindData(data: RestaurantVO) {
       mData = data
       data.imageurl?.let { itemView.ivRestaurant.load(it.toUri()) }
       data.name?.let{ itemView.tvResName.text = it}


       itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapRestaurantItem(it)
            }
        }
    }
}