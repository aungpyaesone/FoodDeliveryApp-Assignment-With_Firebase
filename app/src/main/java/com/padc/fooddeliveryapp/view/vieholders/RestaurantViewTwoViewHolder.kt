package com.padc.fooddeliveryapp.view.vieholders

import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.vertical_item_view.view.*

class RestaurantViewTwoViewHolder(private val mDelegate: FoodItemDelegate, itemView: View) : BaseViewHolder<BurgerVO>(itemView){
    override fun bindData(data: BurgerVO) {
       mData = data
       data.imgurl?.let { itemView.ivRestaurant.load(it.toUri()) }
       data.name?.let{ itemView.tvResName.text = it}


       itemView.setOnClickListener {
            mData?.let {
               mDelegate.onTapFoodItem(it)
            }
        }
    }
}