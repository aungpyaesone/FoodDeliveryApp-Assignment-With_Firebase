package com.padc.fooddeliveryapp.delegates

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.view.view_pods.ItemCountViewPod

interface OrderItemDelegate : ItemCountViewPod.Delegate {
    fun onTapOrderItem(orderItem:BurgerVO)
}