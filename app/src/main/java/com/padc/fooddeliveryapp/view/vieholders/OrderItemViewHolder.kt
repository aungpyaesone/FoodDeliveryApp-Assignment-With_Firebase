package com.padc.fooddeliveryapp.view.vieholders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.delegates.OrderItemDelegate
import com.padc.fooddeliveryapp.uitls.load
import com.padc.fooddeliveryapp.view.view_pods.ItemCountViewPod
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.order_item_view.view.*


class OrderItemViewHolder(private val mDelegate: OrderItemDelegate, itemView: View) : BaseViewHolder<BurgerVO>(itemView) {

    private val mItemCountViewPod: ItemCountViewPod = itemView.itemViewPod as ItemCountViewPod

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapOrderItem(it)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    override fun bindData(data: BurgerVO) {
        mData = data
        data.imgurl?.toUri()?.let { itemView.ivRestaurant.load(it) }
        itemView.tvResName.text = data.name
        itemView.tvPrice.text = "$ ${data.totalAmount?.toInt()}"

        mItemCountViewPod.bindData(data)
        mItemCountViewPod.setDelegate(mDelegate)





    }
}