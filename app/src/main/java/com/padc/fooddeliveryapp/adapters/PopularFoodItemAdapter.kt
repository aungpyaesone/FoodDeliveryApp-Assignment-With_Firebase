package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.view.vieholders.CategoryViewHolder
import com.padc.fooddeliveryapp.view.vieholders.PopularChoiceViewHolder
import com.padc.shared.adapters.BaseAdapter
import com.padc.shared.viewholders.BaseViewHolder

class PopularFoodItemAdapter(private val mDelegate:FoodItemDelegate) : BaseAdapter<BaseViewHolder<BurgerVO>,BurgerVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BurgerVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_horizontial_item_view,parent,false)
        return PopularChoiceViewHolder(mDelegate,v)
    }
}