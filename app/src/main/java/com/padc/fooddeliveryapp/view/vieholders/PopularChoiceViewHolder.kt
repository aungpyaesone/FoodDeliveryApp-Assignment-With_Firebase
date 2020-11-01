package com.padc.fooddeliveryapp.view.vieholders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.food_horizontial_item_view.view.*

class PopularChoiceViewHolder(private val mDelegate: FoodItemDelegate, itemView: View) : BaseViewHolder<BurgerVO>(itemView) {
    @SuppressLint("SetTextI18n")
    override fun bindData(data: BurgerVO) {
        mData = data
        data.imgurl?.toUri()?.let { itemView.ivFood.load(it) }
        itemView.tvName.text = data.name
        itemView.tvPrice.text = "$ ${data.price?.toInt()}"

        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapFoodItem(it)
            }
        }

    }
}