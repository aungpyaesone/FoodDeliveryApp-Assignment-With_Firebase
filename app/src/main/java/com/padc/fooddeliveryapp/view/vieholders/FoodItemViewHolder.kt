package com.padc.fooddeliveryapp.view.vieholders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.burger_list_item_view.view.*


class FoodItemViewHolder(private val mDelegate: FoodItemDelegate,itemView: View) : BaseViewHolder<BurgerVO>(itemView) {
    @SuppressLint("SetTextI18n")
    override fun bindData(data: BurgerVO) {
        mData = data
        data.imgurl?.toUri()?.let { itemView.ivRestaurant.load(it) }
        itemView.tvResName.text = data.name
        itemView.tvPrice.text = "$ ${data.price?.toInt()}"

        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapFoodItem(it)
            }
        }

    }
}